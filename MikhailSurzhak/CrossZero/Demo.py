from Games import CrossZero as CrossZero
import sys

try:
    size = int(sys.argv[1])
except Exception:
    size = 3

game = CrossZero(size)
game.play()

if game.state == CrossZero.State.CROSS_WIN:
    print("The 'X' win!")
elif game.state == CrossZero.State.ZERO_WIN:
    print("The 'O' win!")
else:
    print("Combat draw.")

input("Press Enter to exit ...")