class MoneyBox:
    def __init__(self, capacity):
   # конструктор с аргументом – вместимость копилки
        self.coins = 0
        self.capacity = capacity

    def can_add(self, v):
        # True, если можно добавить v монет, False иначе

        if v + self.coins <= self.capacity:
            return True
        else:
            return False

    def add(self, v):
        # положить v монет в копилк
        if self.can_add(v) and v + self.coins <= self.capacity:
            self.coins += v

z = MoneyBox(10)
print(z.capacity)
print(z.can_add(6))
z.add(6)
print(z.coins)
print(z.capacity)
print(z.can_add(6))