package oxcs.tictactoe.MainGame;

public class GameGrid {

    private final StringBuilder stringBuilder;
    private boolean UseMoreLines = false;
    private int[] GridStorage = new int[9];
    private int UsedCells = 0;
    private int[] FreeCells = new int[9];

    public GameGrid() {
        this.stringBuilder = new StringBuilder();
    }

    public void resetGrid() {
        this.GridStorage = new int[9];
        this.UsedCells = 0;
        this.FreeCells = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    public void fillGridRand() {
        for (int i = 0; i < this.GridStorage.length; i++) {
            this.GridStorage[i] = -1 + (int) Math.round(Math.random() * 2);
            if (this.GridStorage[i] != 0) this.UsedCells++;
        }
    }

    public boolean toggleMoreLines() {
        return this.UseMoreLines = !this.UseMoreLines;
    }

    public int[] getGrid() {
        return this.GridStorage;
    }

    public int[] getFreeCells() {
        return this.FreeCells;
    }

    public int getUsedCells() {
        return this.UsedCells;
    }

    public boolean setCell(String address, int val) {
        int cellId = cellStrToId(address);
        return setCell(cellId, val);
    }

    public boolean setCell(int cellId, int val) {
        if (cellId != -1 && this.GridStorage[cellId] == 0) {
            this.GridStorage[cellId] = val;
            this.UsedCells++;
            updateFreeCells();
            return true;
        } else {
            return false;
        }
    }

    public String getDisplayString() {
        this.stringBuilder.delete(0, this.stringBuilder.length());
        this.stringBuilder.append("  A B C");

        for (int i = 0; i < this.GridStorage.length; i++) {
            if (i % 3 == 0) {
                if (this.UseMoreLines) this.stringBuilder.append(i > 2 ? "\n |-----|\n" : "\n -------\n");
                else this.stringBuilder.append('\n');
                this.stringBuilder.append(1 + i / 3);
                this.stringBuilder.append('|');
            }
            this.stringBuilder.append(getSymbol(this.GridStorage[i]));
            this.stringBuilder.append('|');
        }
        this.stringBuilder.append(this.UseMoreLines ? "\n -------" : "");
        return this.stringBuilder.toString();
    }


    public int checkWin() {
        if (this.UsedCells <= 3) {
            return 0;
        }
        int check;
        int res;
        for (int i = 0; i < 9; i += 3) {
            check = this.GridStorage[i] + this.GridStorage[i + 1] + this.GridStorage[i + 2];
            res = ch(check);
            if (res != 0) return res;
        }
        for (int i = 0; i < 3; i++) {
            check = this.GridStorage[i] + this.GridStorage[i + 3] + this.GridStorage[i + 6];
            res = ch(check);
            if (res != 0) return res;
        }
        check = this.GridStorage[0] + this.GridStorage[4] + this.GridStorage[8];
        res = ch(check);
        if (res != 0) return res;
        check = this.GridStorage[2] + this.GridStorage[4] + this.GridStorage[6];
        res = ch(check);
        if (res != 0) return res;
        if (this.UsedCells == 9) {
            return 10;
        }
        return 0;
    }

    private int ch(int check) {
        if (check == 3) return 1;
        else if (check == -3) return -1;
        else return 0;
    }

    private void updateFreeCells() {
        this.FreeCells = new int[9 - this.UsedCells];
        int fci = 0;
        for (int i = 0; i < 9; i++) {
            if (this.GridStorage[i] == 0) {
                this.FreeCells[fci] = i;
                fci++;
            }
        }
    }

    private char getSymbol(int cellValue) {
        switch (cellValue) {
            case 1: {
                return 'X';
            }
            case -1: {
                return '0';
            }
            default:
                return ' ';
        }
    }

    private int cellStrToId(String address) {
        return switch (address.toUpperCase()) {
            case "A1" -> 0;
            case "B1" -> 1;
            case "C1" -> 2;
            case "A2" -> 3;
            case "B2" -> 4;
            case "C2" -> 5;
            case "A3" -> 6;
            case "B3" -> 7;
            case "C3" -> 8;
            default -> -1;
        };
    }


}
