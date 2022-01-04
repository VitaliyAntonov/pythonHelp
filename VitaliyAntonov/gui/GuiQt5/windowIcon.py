# !/usr/bin/python3
# -*- coding: utf-8 -*-

# PyQt5: первые программы
# Ссылка на статью:  https://pythonworld.ru/gui/pyqt5-firstprograms.html

# Значок приложения - небольшое изображение, которое обычно отображается
# в верхнем левом углу заголовка


import sys

from PyQt5.QtCore import QCoreApplication
from PyQt5.QtWidgets import (QWidget, QToolTip,
                             QPushButton, QApplication)
from PyQt5.QtGui import QIcon
from PyQt5.QtGui import QFont


class Example(QWidget):
    """ Здесь мы создаем новый класс Example. Класс Example наследуется от класса QWidget.
    Это означает, что мы вызываем два конструктора:
    первый для класса Example и второй для родительского класса. """

    def __init__(self):
        # Функция super() возвращает родительский объект Example с классом, и мы вызываем его конструктор.
        super().__init__()

        # Создание GUI делегируется методу initUI().
        self.initUI()

    def initUI(self):
        """ Создание GUI """

        # Этот статический метод устанавливает шрифт, используемый для отображения подсказки.
        QToolTip.setFont(QFont('SansSerif', 10))

        # Всплывающая подсказка, мы вызываем метод setToolTip().
        # Мы можем использовать форматирование текста.
        self.setToolTip('This is a <b>QWidget</b> widget')

        # Создание кнопки
        qbtn = QPushButton('Quit', self)

        # Система обработки событий в PyQt5 построена на механизме сигналов и слотов.
        # Если мы нажмем на кнопку, вызовется сигнал "нажатие".
        # Слот может быть слот Qt или любая Python функция.
        #
        # QCoreApplication содержит главный цикл обработки;
        # он обрабатывает и диспетчеризирует все события.
        # Метод instance() дает нам его текущий экземпляр.
        #
        # Обратите внимание, что QCoreApplication создается с QApplication.
        # Сигнал "нажатие" подключен к методу quit(), который завершает приложение.
        # Коммуникация осуществляется между двумя объектами: отправителя и приемника.
        # Отправитель кнопка, приемник - объект приложения.
        qbtn.clicked.connect(QCoreApplication.instance().quit)

        # всплывающая подсказка
        qbtn.setToolTip('This is a <b>QPushButton</b> widget')

        # Метод sizeHint() дает рекомендуемый размер для кнопки.
        qbtn.resize(qbtn.sizeHint())
        qbtn.move(50, 50)

        #  setGeometry помещает окно на экране и устанавливает его размер.
        #  Первые два параметра х и у - это позиция окна.
        #  Третий - ширина, и четвертый - высота окна.
        #  На самом деле, он сочетает в себе методы resize() и move() в одном методе.
        self.setGeometry(300, 300, 300, 220)

        self.setWindowTitle('Icon')

        # setWindowIcon устанавливает иконку приложения.
        # Чтобы сделать это, мы создали объект QIcon.
        # QIcon получает путь к нашей иконке для отображения.
        self.setWindowIcon(QIcon('pycharm.png'))

        self.show()


if __name__ == '__main__':
    # Создаются объекты application и Example. Запускается основной цикл.
    app = QApplication(sys.argv)
    ex = Example()
    sys.exit(app.exec_())
