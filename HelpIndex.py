from PythonHelpFiles.SetsInfo import SetsInfo
from PythonHelpFiles.ListInfo import ListInfo
from PythonHelpFiles.DictInfo import DictInfo


class HelpIndex:
    """ Общий индекс """

    def __init__(self):

        # Множества
        SetsInfo.create_help()
        SetsInfo.len_help()
        SetsInfo.x_in_help()
        SetsInfo.isdisjoint_help()
        SetsInfo.compare_help()
        SetsInfo.issubset_help()
        SetsInfo.issuperset_help()
        SetsInfo.union_help()
        SetsInfo.intersection_help()
        SetsInfo.difference_help()
        SetsInfo.symmetric_difference_help()
        SetsInfo.copy_help()

        # операции, непосредственно изменяющие множество
        SetsInfo.update_help()
        SetsInfo.intersection_update_help()
        SetsInfo.difference_update_help()
        SetsInfo.symmetric_difference_update_help()
        SetsInfo.add_help()
        SetsInfo.remove_help()
        SetsInfo.discard_help()
        SetsInfo.pop_help()
        SetsInfo.clear_help()

        # list строки
        ListInfo.list_help()

        # Словари
        DictInfo.create_help()
        DictInfo.len_help()
        DictInfo.x_in_help()
        DictInfo.clear_help()
        DictInfo.copy_help()
        DictInfo.fromkeys_help()
        DictInfo.get_help()
        DictInfo.items_help()
        DictInfo.keys_help()
        DictInfo.pop_help()
        DictInfo.popitem_help()
        DictInfo.setdefault_help()
        DictInfo.update_help()
        DictInfo.values_help()
