import React, { useState, useEffect } from "react";

import { TodoForm } from "../components/TodoForm";
import { TodoList } from "../components/TodoList";
import { ITodo } from "../interfaces";

declare var confirm: (question: string) => boolean;

export const TodosPage: React.FC = () => {
  const [todos, setTodos] = useState<ITodo[]>([]);

  // Когда второй параметр - пустой массив, хук будет вызван после того, как Реакт уже соединил шаблон с DOM-деревом
  useEffect(() => {
    const saved = JSON.parse(localStorage.getItem("todos") || "[]") as ITodo[];
    setTodos(saved);
  }, []);

  // Этот эффект выполнится, только когда стейт todos будет изменён
  useEffect(() => {
    localStorage.setItem("todos", JSON.stringify(todos));
  }, [todos]);

  const addHandler = (title: string) => {
    const newTodo: ITodo = {
      title: title,
      id: Date.now(),
      completed: false,
    };
    setTodos((prev) => [newTodo, ...prev]);
  };

  // Почему-то если использовать коллбэк в setState в режиме devsrever, тело коллбэка выполняется дважды. Нужно разобраться, в чём дело
  // const toggleHandler = (id: number) => {
  //   setTodos((prev) => {
  //     console.log("ok");
  //     return prev.map((todo) => {
  //       if (todo.id === id) {
  //         todo.completed = !todo.completed;
  //       }
  //       return todo;
  //     });
  //   });
  // };

  // Пока решил просто не использовать коллбэк
  const toggleHandler = (id: number) => {
    setTodos(
      todos.map(todo => {
        if (todo.id === id) {
          todo.completed = !todo.completed;
        }
        return todo;
      })
    );
  };

  // здесь коллбэк также выполняется дважды...
  const removeHandler = (id: number) => {
    const shouldRemove = confirm("Вы уверены, что хотите удалить элемент?");
    if (shouldRemove) {
      setTodos(prev => prev.filter(todo => todo.id !== id));
    }
  };

  return <React.Fragment>
    <TodoForm onAdd={addHandler} />
    <TodoList
      todos={todos}
      onToggle={toggleHandler}
      onRemove={removeHandler}
    />
  </React.Fragment>
};