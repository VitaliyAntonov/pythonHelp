import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0, 5, 10)
y = x ** 2

# построение графика y=x*x
plt.figure()
plt.plot(x, y, 'r')
plt.xlabel('x')
plt.ylabel('y')
plt.title('title')

# сохранение графика на компьютер
plt.savefig("mygraph.png")

plt.show()
