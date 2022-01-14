from PythonHelpFiles.SetsInfo import SetsInfo


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



