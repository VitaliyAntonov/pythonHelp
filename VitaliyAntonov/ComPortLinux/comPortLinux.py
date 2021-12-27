# ! /usr/bin/env python
# coding: utf-8

# статья: Последовательный порт. Да, поможет нам Python!
# ссылка:
# https://zhevak.wordpress.com/2014/02/11/%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9-%D0%BF%D0%BE%D1%80%D1%82-%D0%B4%D0%B0-%D0%BF%D0%BE%D0%BC%D0%BE%D0%B6%D0%B5%D1%82-%D0%BD%D0%B0%D0%BC-p/


import serial


# Следующая программа позволяет найти в системе все последовательные порты
def scan_ports():
    """ Поиск в системе всех последовательных портов """
    found = False
    for i in range(64):
        try:
            port = "/dev/ttyS%d" % i
            ser = serial.Serial(port)
            ser.close()
            print("Найден последовательный порт: ", port)
            found = True
        except serial.serialutil.SerialException:
            pass

    if not found:
        print("Последовательных портов не обнаружено")


# Следующая программа забирает поток данных из последовательного порта и выводит его на экран

def data_from_com_to_log():
    ser = serial.Serial("/dev/eng1")
    ser.baudrate = 115200

    while True:
        line = ser.readline()
        print(line,)


if __name__ == '__main__':
    data_from_com_to_log()
