import os


class FolderIndex:
    """ Класс для сканирования директории """

    def __init__(self, path):  # Конструктор класса

        self.rootPath = path
        """ путь к сканируемой папке """

        self.emptyPaths = []
        """ список пустых папок в виде Road """

        self.fileNamesRoad = []
        """ список имён файлов с путями к ним в виде FNameRoad """

        self.doubleFileNames = []
        """ список для фиксации файлов с одинаковыми именами """

        # индексируем папку
        self.scan_folder()

    # ------------------------------------------------------------------------------------
    # сканирует папку с путём,
    # сложенным из: self.rootPath, пути папки верхнего уровня и имени вложенной папки
    #
    # при обнаружении имён файлов - имя файла с записью пути к нему
    # добавляется к fileNamesRoad
    #
    # Если имя файла уже есть в fileNamesRoad,
    # имя файла и массив пути добавляется в список doubleFilesBuffer
    #
    # Если папка пуста, путь к ней добавляется в массив путей к пустым папкам emptyPaths
    #
    # @param pathUp       - путь к корневой папке(path) - массив имён вложенных папок
    # @param nameFolder   - имя сканируемой папки
    #
    # @return Boolean
    def scan_folder(self, pathUp=[], nameFolder=None):
        """ Функция сканирует папку и все вложения в неё. Формирует списки класса """

        retValue = bool(1)  # возвращаемое значение

        # Определяем путь
        dirPath = self.rootPath
        if pathUp is not None:
            for dirName in pathUp:
                dirPath = dirPath + '/' + dirName
        if nameFolder is not None:
            dirPath = dirPath + '/' + nameFolder

        if os.path.exists(dirPath):  # путь существует
            if os.path.isdir(dirPath):  # это папка

                # добавляем имя папки nameFolder к новому пути, если nameFolder не пустой
                newPathUp = pathUp.copy()
                if nameFolder is not None:
                    if pathUp is not None:
                        newPathUp.append(nameFolder)
                    else:
                        newPathUp = list([nameFolder,])

                fileList = os.listdir(dirPath)  # создаём список вложенных

                # количество обнаруженных объектов в папке */
                objetsCount = 0

                for name in fileList:  # обходим список вложенных

                    if os.path.isdir(dirPath + '/' + name):  # это папка
                        objetsCount = objetsCount + 1
                        # Здесь уходим на рекурсивный вызов с обнаруженной папкой
                        self.scan_folder(newPathUp, name)
                    elif os.path.isfile(dirPath + '/' + name):  # это файл
                        objetsCount = objetsCount + 1
                        # проверяем наличие имени файла в списке fileNamesRoad ? - делать для дублей
                        self.fileNamesRoad.append(FNameRoad(name, newPathUp)) # добавляем файл и путь в список
            else:
                retValue = bool(0)
        else:
            retValue = bool(0)

        return retValue
    # ----------------------------------------------------------------------------------------

    def debug_fname_file_Road(self):
        """ Вывод в консоль списка отсканированных файлов и путей к ним """
        print('Список файлов в сканируемой папке')
        print(f'Всего файлов: {len(self.fileNamesRoad)}')
        for feature in self.fileNamesRoad:
            s = f'{feature.fileName}  path: '
            for pn in feature.fileRoad:
                s += '/' + pn
            print(s)


class FNameRoad:
    """
    Класс для хранения имени файла и пути к нему в виде списка строк с именами вложенных папок, начиная от корня
    """

    def __init__(self, fName, fRoad):
        self.fileName = fName
        self.fileRoad = fRoad


# Пустой класс
class EmptyClass:
    pass


if __name__ == '__main__':

    # путь к сканируемой папке
    path = '/home/vitaliy/PycharmProjects/pythonProject'
    # path = '/home/vitaliy/PycharmProjects/pythonProject/emptyTestDir'
    # path = '.'

    newScan = FolderIndex(path)  # создаём индекс

    newScan.debug_fname_file_Road()  # выводим список файлов с путями к ним в консоль

    # print(newScan)

    print("")
    print("")

    print(FolderIndex.__name__ + "   " + FolderIndex.__doc__)

    print("")
    print("")
