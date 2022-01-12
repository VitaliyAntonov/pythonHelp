from pythonHelp.VitaliyAntonov.helpIndex.SetsInfo import SetsInfo


class HelpIndex:
    """ Общий индекс """

    def __init__(self):

        # Множества
        SetsInfo.create_set()
        SetsInfo.len_set()
        SetsInfo.x_in_set()
        SetsInfo.isdisjoint_set()
        SetsInfo.compare_set()
        SetsInfo.issubset_set()
        SetsInfo.issuperset_set()
        SetsInfo.union_set()
        SetsInfo.intersection_set()
        SetsInfo.difference_set()
        SetsInfo.symmetric_difference_set()
        SetsInfo.copy_set()

        # операции, непосредственно изменяющие множество
        SetsInfo.update_set()
        SetsInfo.intersection_update_set()
        SetsInfo.difference_update_set()
        SetsInfo.symmetric_difference_update_set()
        SetsInfo.add_set()
        SetsInfo.remove_set()
        SetsInfo.discard_set()
        SetsInfo.pop_set()
        SetsInfo.clear_set()



