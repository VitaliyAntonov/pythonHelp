""" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# построение графика способом, отличным от способа в предыдущем уроке
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)                   # генерация 10 чисел с равным шагом на отрезке от 0 до 5 включительно
y = x ** 2                                  # y = x^2

# построение графика y=x*x
fig = plt.figure()                          # создание спец. объект figure
axes = fig.add_axes([0.1, 0.1, 0.8, 0.8])   # создание осей

axes.plot(x, y, 'r')
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_title('title')

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
"""




""" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# построение двух графиков на одной картинке
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)                        # генерация 10 чисел с равным шагом на отрезке от 0 до 5 включительно
y = x ** 2                                       # y = x^2

# построение графика y=x*x
fig = plt.figure()                               # создание спец. объект figure

# создание осей
axes1 = fig.add_axes([0.1, 0.1, 0.8, 0.8])       # главные оси
axes2 = fig.add_axes([0.2, 0.5, 0.4, 0.3])       # внутренние оси

# main figure
axes1.plot(x, y, 'r')
axes1.set_xlabel('x')
axes1.set_ylabel('y')
axes1.set_title('title')

# insert
axes2.plot(y, x, 'g')
axes2.set_xlabel('y')
axes2.set_ylabel('x')
axes2.set_title('insert title')

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
"""




"""!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# построение двух одинаковых графиков раздельно (в одной строке)
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)                       # генерация 10 чисел с равным шагом на отрезке от 0 до 5 включительно
y = x ** 2                                      # y = x^2

# построение графика y=x*x
fig, axes = plt.subplots(nrows=1, ncols=2)      # создание спец. объект figure и создание осей

for ax in axes:
    ax.plot(x, y, 'r')
    ax.set_xlabel('x')
    ax.set_ylabel('y')
    ax.set_title('title')

fig.tight_layout()                              # плотная компановка

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
"""



"""!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# построение графиков с настройкой размера графика
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)                        # генерация 10 чисел с равным шагом на отрезке от 0 до 5 включительно
y = x ** 2                                       # y = x^2

# построение графика y=x*x
fig, axes = plt.subplots(figsize=(12, 3))        # создание спец. объект figure с размером 12х3 дюйма и создание осей

axes.plot(x, y, 'r')
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_title('title')

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
"""










"""!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# построение двух графиков на одних осях с созданием дополнительной легенды
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)                  # генерация 10 чисел с равным шагом на отрезке от 0 до 5 включительно

fig, ax = plt.subplots()                   # создание спец. объект figure и создание осей
ax.plot(x, x ** 2, label="y = x**2")
ax.plot(x, x ** 3, label="y = x**3")
ax.legend(loc=2)                           # создание легенды в левом верхнем углу

ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_title('title')

# сохранение графика на компьютер
plt.savefig("mygraph.png")
plt.show()
"""






# построение гистограм
import numpy as np
import matplotlib.pyplot as plt

# создание массива случайных значений с нормальным распределением
n = np.random.randn(100000)

fig, axes = plt.subplots(1, 2, figsize=(12, 4))   # создание спец. объект figure с размером 12х4 дюйма и создание осей

# Default histogram
axes[0].hist(n)
axes[0].set_title('Default histogram')
axes[0].set_xlim(min(n), max(n))

# Cumulative detailed histogram
axes[1].hist(n, cumulative=True, bins=50)
axes[1].set_title('Cumulative detailed histogram')
axes[1].set_xlim(min(n), max(n))

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
