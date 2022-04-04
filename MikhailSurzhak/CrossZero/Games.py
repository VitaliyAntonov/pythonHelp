import os
import random
import time
import collections


class CrossZero:
    """ The game Cross-Zero"""

    class State:
        """ Contains game state constants"""

        OPEN, DRAW, CROSS_WIN, ZERO_WIN = range(-1, 3)

    def __init__(self, size=3):
        if size < 3:
            size = 3
        elif size > 9:
            size = 9
        if size % 2 == 0:
            size -= 1

        self.__move = 0
        self.__state = CrossZero.State.OPEN
        self.__size = size
        self.__field = [[-size] * size for i in range(size)]        
        """
        -3 -3 -3 
        -3 -3 -3 
        -3 -3 -3
        """

        # The list of lines that need to be filled with crosses or zeros
        self.__lines = [[-size] * size for i in range(size + size + 2)] 

        # Cell indexes in self.__lines
        self.__index = []

        # Append cell indexes in rows
        for i in range(self.__size):
            line = []
            for j in range(self.__size):
                line.append((i, j))
            self.__index.append(line)

        # Append cell indexes in columns
        for j in range(self.__size):
            line = []
            for i in range(self.__size):
                line.append((i, j))
            self.__index.append(line)

        # Append cell indexes in the main diagonal
        line = []
        for i in range(self.__size):
            line.append((i, i))
        self.__index.append(line)

        # Append cell indexes in the auxiliary diagonal
        n = self.__size-1
        line = []
        for i in range(self.__size):
            line.append((i, n-i))
        self.__index.append(line)

    @property
    def state(self):
        return self.__state

    def get_lines(self):
        """ Return the list of lines with the current state of cells"""

        res = []
        # Append rows
        for i in range(self.__size):
            res.append(self.__field[i])

        # Append columns
        for j in range(self.__size):
            line = [self.__field[0][j]]
            for i in range(1, self.__size):
                line.append(self.__field[i][j])
            res.append(line)

        # Append the main diagonal
        line = [self.__field[0][0]]
        for i in range(1, self.__size):
            line.append(self.__field[i][i])
        res.append(line)

        # Append the auxiliary diagonal
        n = self.__size-1
        line = [self.__field[0][n]]
        for i in range(1, self.__size):
            line.append(self.__field[i][n-i])
        res.append(line)

        return res

    def show(self): 
        """ Show playing field on the display"""

        if os.name == "nt":
            os.system("cls")
        else:
            print("\n" * 100)

        for i in range(self.__size):
            print("{}  ".format(self.__size-i), end="") # row number
            for j in range(self.__size):
                if j == self.__size-1:
                    separ_char = " "
                else:
                    separ_char = "\u2502" # vertical line
                z = self.__field[i][j]
                if z > 0:
                    print(" X ", end=separ_char)
                elif z == 0:
                    print(" O ", end=separ_char)
                else:
                    print("   ", end=separ_char)
            print()
            if i < self.__size-1: # dividing line between rows                
                hline = "\u2500\u2500\u2500\u253c" # ---+
                hline = hline * (self.__size-1)
                print("   {}\u2500\u2500\u2500".format(hline))

        # letters denoting columns
        a = ord('a')
        print("\n   ", end="")
        for i in range(self.__size):
            print(" {} ".format(chr(a+i)), end=" ")
        print("\n")

    def mark(self, row, col):
        """ Mark the cell with a cross or a zero"""

        if row < 1 or row > self.__size or \
           col < 1 or col > self.__size:
            return False

        i = self.__size - row
        j = col - 1

        if self.__field[i][j] >= 0:
            return False

        self.__move += 1
        self.__field[i][j] = self.__move % 2
        self.__lines = self.get_lines()
        return True

    def parse(self, text):
        """ Converts a string with a command to a row and column number"""

        if len(text) < 2:
            return 0, 0

        a1 = ord('A')
        a2 = a1 + self.__size -1 
        d1 = ord('1')
        d2 = d1 + self.__size -1

        c = ord(text[0].upper())
        r = ord(text[1])

        if d1 <= r <= d2:
            row = r - d1 + 1
        else:
            row = 0
       
        if a1 <= c <= a2:
            col = c - a1 + 1
        elif d1 <= c <= d2:
            col = c - d1 + 1
        else:
            col = 0

        return row, col

    def matrix_analys(self): 
        """ Performs an analysis of the state of the game: 
        whether there is a winner,
        whether it is possible to continue the game ..."""

        # Search for a winner
        for line in self.__lines:
            s = sum(line)
            if s == 0:
                self.__state = CrossZero.State.ZERO_WIN
                return self.__state
            if s == self.__size:
                self.__state = CrossZero.State.CROSS_WIN
                return self.__state
   
        # There is no winner. Are there any moves?
        if self.__move < (self.__size * self.__size):
            self.__state = CrossZero.State.OPEN
            return self.__state

        # No moves, no winner - it's a draw
        self.__state = CrossZero.State.DRAW
        return self.__state

    def ai_central(self):
        """ Artificial intelligence is trying to occupy the central cell"""

        i = self.__size // 2
        if self.__field[i][i] == -self.__size:
            return i+1, i+1
        return 0, 0

    def ai_force(self, mode):
        """ Artificial intelligence on the next move tries to win, 
        or at least not to lose"""

        for k in range(len(self.__lines)):
            if sum(self.__lines[k]) == mode:
                for v in range(self.__size):
                    if self.__lines[k][v] == -self.__size:
                        cell = self.__index[k][v]
                        row = self.__size - cell[0]
                        col = cell[1] + 1
                        return row, col
        return 0, 0

    def random_row_col(self, empty_cells):
        """ Get a row and column of a random cell from a list"""

        count = len(empty_cells)
        if count < 1:
            return 0, 0
        n = random.randint(1, count) - 1
        row = self.__size - empty_cells[n][0]
        col = empty_cells[n][1] + 1
        return row, col

    def ai_defense(self): 
        """ Artificial intelligence prevents the filling of lines"""

        # Prevents the filling of lines
        rating_1 = collections.defaultdict(int)
        for k in range(len(self.__lines)):
            cross = False
            zero = False
            for v in range(self.__size):
                val = self.__lines[k][v]
                if val == 0:
                    zero = True
                elif val == 1:
                    cross = True
            
            if not zero and cross:
                for v in range(self.__size):
                    val = self.__lines[k][v]
                    if val == -self.__size:
                        cell = self.__index[k][v]
                        rating_1[cell] += 1

        if len(rating_1) == 0:
            return 0, 0

        maxval = max(rating_1.values())

        # Captures free lines
        rating_2 = collections.defaultdict(int)
        for key in rating_1.keys():
            if rating_1[key] == maxval:
                rating_2[key] = rating_1[key]
               
        for k in range(len(self.__lines)):
            if sum(self.__lines[k]) == -(self.__size * self.__size):
                for v in range(self.__size):
                    cell = self.__index[k][v]
                    rating_2[cell] += 1

        maxval = max(rating_2.values())

        empty_cells = []        
        for key in rating_2.keys():
            if rating_2[key] == maxval:
                empty_cells.append(key)

        return self.random_row_col(empty_cells)

    def ai_random(self):
        """ Choosing a cell randomly"""

        empty_cells = []
        for i in range(self.__size):
            for j in range(self.__size):
                if self.__field[i][j] == -self.__size:
                    empty_cells.append((i, j))
        
        return self.random_row_col(empty_cells)

    def ai(self):
        """ The logic of artificial intelligence"""

        res = self.ai_central()
        if sum(res) > 0:
            return res

        checkmate = -self.__size
        alarm = -1

        res = self.ai_force(checkmate)
        if sum(res) > 0:
            return res

        res = self.ai_force(alarm)
        if sum(res) > 0:
            return res
       
        res = self.ai_defense()
        if sum(res) > 0:
            return res

        return self.ai_random()

    def play(self):
        """ Gameplay. A human plays with crosses and moves first"""

        self.show()
        while self.matrix_analys() == CrossZero.State.OPEN:
            if self.__move % 2 == 0:
                cmd = self.parse(input("X>"))
            else:
                cmd = self.ai()
                time.sleep(2)
            self.mark(*cmd)
            self.show()

        return self.state

