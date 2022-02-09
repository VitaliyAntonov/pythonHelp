class Game():
    def __init__(self):
        self.field = { #здесь хранится состояние игрового поля
            'A1': ' ',
            'A2': ' ',
            'A3': ' ',
            'B1': ' ',
            'B2': ' ',
            'B3': ' ',
            'C1': ' ',
            'C2': ' ',
            'C3': ' '
            }
        self.player = 'Крестики' #игрок, который делает ход
        self.codes = { #различные результаты попытки записать поле
            0:'Ход успешно сделан.',
            1:'Неверный адрес поля. Повторите ввод.',
            2:'Поле уже занято. Сделайте другой ход.'
            }
        self.win_combinations = [ #варианты выигрышных комбинаций
            ('A1','A2','A3'),
            ('B1','B2','B3'),
            ('C1','C2','C3'),
            ('A1','B2','C3'),
            ('C1','B2','A3'),
            ('A1','B1','C1'),
            ('A2','B2','C2'),
            ('A3','B3','C3')
            ]
        self.numberstep = 0 #номер хода
        
    def out(self): #Метод выводит игровое поле
        print(f'''    A   B   C
  -------------
1 | {self.field["A1"]} | {self.field["B1"]} | {self.field["C1"]} |
  |-----------|
2 | {self.field["A2"]} | {self.field["B2"]} | {self.field["C2"]} |
  |-----------|
3 | {self.field["A3"]} | {self.field["B3"]} | {self.field["C3"]} |
  -------------''')

    def validate(self,input_adress): #валидация ввода
        val_adress = input_adress.upper().replace(' ','')
        return val_adress
                
    def write(self,mode): #функция записи хода в поле
        if mode == 'multi' or self.player == 'Крестики':
            adress = self.validate(input(f'{self.player} ходят: ')) #пользовательсктй ввод
        else:
            adress = self.adress_ii() #получаем ход от ИИ
        try:
            if self.field[adress] != ' ':
                return 2
        except KeyError:
            return 1
        if self.player == 'Крестики':
            self.field[adress] = 'X'
        else:
            self.field[adress] = '0'
        return 0
    
    def adress_ii(self): #функция расчета хода ИИ. В начале прописаны ответы на первый ход
        if self.numberstep == 1:
            if self.field['B2'] == 'X':
                return 'A3'
            if self.field['A1'] == 'X':
                return 'B2'
            if self.field['C1'] == 'X':
                return 'B2'
            if self.field['C3'] == 'X':
                return 'B2'
            if self.field['A3'] == 'X':
                return 'B2'

        results_x = [] #направления, на которых возможен выигрыш
        results_o = []
        for c in self.win_combinations:
            result_dict = {cell: self.field[cell] for cell in c}
            result_list = [self.field[cell] for cell in c]
            if 'X' in result_list and not ('0' in result_list) and ' ' in result_list:
                results_x.append(result_dict)
            if '0' in result_list and not ('X' in result_list) and ' ' in result_list:
                results_o.append(result_dict)
            if ' ' in result_list and result_list.count('0') == 2 or result_list.count('X') == 2:#когда 2 в ряд
                for k in result_dict:
                    if result_dict[k] == ' ':
                        return k
        r_list = []
        results = results_o if len(results_o)>0 else results_x#выбор по количеству возможных направлений для выигрыша
        for r in results:
            for k in r:
                if r[k] == ' ':
                    r_list.append(k)
        adress = max(set(r_list), key = r_list.count)
        return adress
                
    def check_win(self): #проверка на победу после каждого хода
        results = []
        for c in self.win_combinations:
            result = [self.field[cell] for cell in c]
            if 'X' in result and '0' in result:
                results.append(result)
                continue
            if result[0] != ' ' and result[0] == result[1] and result[2] == result[1]:
                return f'{self.player} победили!'
        if len(results) == 8:
            return 'Ничья!'
        return None
                
        
    def play(self,mode): #игровой цикл
        while True:
            res = self.write(mode)
            print(self.codes[res])
            if res != 0:
                continue            
            self.out()
            winner = self.check_win()
            if winner is not None:
                print(winner)
                return None
            self.player = 'Нолики' if self.player == 'Крестики' else 'Крестики'
            self.numberstep += 1

while True:
    game = Game()
    mode = 'single' if input('Введите 1 для игры с компьютером, 2 - для игры вдвоем ') == '1' else 'multi'
    game.play(mode)
    input('Нажмите Enter для новой игры')
