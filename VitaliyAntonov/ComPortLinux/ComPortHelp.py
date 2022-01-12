# pySerial API - документация к пакету
# https://pyserial.readthedocs.io/en/latest/pyserial.html


# Открытие последовательных портов
import serial
import io

# Краткое введение
# Открытие последовательных портов
# https://pyserial.readthedocs.io/en/latest/shortintro.html
from pyparsing import unicode


def help_serial_open():
    """ открытие порта; проверка, какой порт используется; закрытие порта """

    # Открыть порт на «9600,8, N, 1», без тайм-аута:
    ser = serial.Serial('/dev/ttyUSB0')  # открытие порта
    print(ser.name)  # проверка, какой порт используется
    ser.write(b'hello')  # отправка строки в порт
    ser.close()  # закрытие порта

    # Открыть именованный порт на «19200,8, N, 1», таймаут 1 с:
    with serial.Serial('/dev/ttyS1', 19200, timeout=1) as ser:
        x = ser.read()          # чтение одного байта
        s = ser.read(10)        # читать до десяти байт (таймаут)
        line = ser.readline()   # прочитать строку с завершением '\n'

    # Открыть порт на «38400,8, E, 1», неблокирующее квитирование HW:
    ser = serial.Serial('COM3', 38400, timeout=0, parity=serial.PARITY_EVEN, rtscts=1)
    s = ser.read(100)           # читать до ста байт
                                # или столько же в буфере
    ser.close()                 # закрытие порта

    # Создание экземпляра порта и настройка / открытие его позже:

    ser = serial.Serial()
    ser.baudrate = 19200
    ser.port = 'COM1'
    # ser >>> Serial<id=0xa81c10, open=False>(port='COM1', baudrate=19200, bytesize=8, parity='N', stopbits=1, timeout=None, xonxoff=0, rtscts=0)
    ser.open()
    test_open = ser.is_open  # >>> test_open = True
    ser.close()
    test_close = ser.is_open # >>> test_close = False

    # Также поддерживается диспетчером контекста :

    with serial.Serial() as ser:
        ser.baudrate = 19200
        ser.port = 'COM1'
        ser.open()
        ser.write(b'hello')


    # readline () читает до одной строки, включая \n в конце.
    # Будьте осторожны при использовании readline().
    # Укажите тайм-аут при открытии последовательного порта,
    # иначе он может заблокироваться навсегда, если не будет получен символ новой строки.
    # Если \n отсутствует в возвращаемом значении, оно возвращается по таймауту.


    # Чтобы указать символ EOL для readline() или использовать универсальный режим новой строки,
    # рекомендуется использовать io.TextIOWrapper:

    # import serial
    # import io
    ser = serial.serial_for_url('loop://', timeout=1)
    sio = io.TextIOWrapper(io.BufferedRWPair(ser, ser))

    sio.write(unicode("hello\n"))
    sio.flush()  # it is buffering. required to get the data out *now*
    hello = sio.readline()
    print(hello == unicode("hello\n"))



def help_class_serial_Serial():
    pass




