package oxcs.MainGame;

import java.util.ArrayList;
import java.util.Arrays;

public class AI {

    private final int[] GridStorage;
    private final int Side;
    private final int[] Corners = {0, 2, 6, 8};
    private final int[][] CornerPairs = {{0, 8}, {2, 6}, {6, 2}, {8, 0}};
    private int UsedCells = 0;
    private int[] FreeCells = new int[9];

    private double level;

    public AI(int[] grid, int side, AILevel level) {
        GridStorage = grid;
        Side = side;
        switch (level) {
            case Beginner -> this.level = 0.3;
            case Normal -> this.level = 0.5;
            case Advanced -> this.level = 0.8;
            case Expert -> this.level = 0.95;
            case Machine -> this.level = 1;
        }
    }

    public int getSide() {
        return this.Side;
    }

    public int getMove() {
        int mv;
        if (Math.random() - 0.04 < this.level) {
            mv = first();
            if (mv != -1) return mv;
        }
        if (Math.random() - 0.18 < this.level) {
            mv = win();
            if (mv != -1) return mv;
        }
        if (Math.random() < this.level) {
            mv = fork();
            if (mv != -1) return mv;
        }
        if (Math.random() - 0.04 < this.level) {
            mv = stSet();
            if (mv != -1) return mv;
        }
        return FreeCells[(int) Math.floor(Math.random() * FreeCells.length)];
    }

    public void updateFree(int[] freeCells) {
        FreeCells = freeCells;
        UsedCells = 9 - freeCells.length;
    }

    private int first() {
        if (UsedCells == 1 && GridStorage[4] == 0) return 4;
        else if (UsedCells <= 1) return Corners[(int) Math.floor(Math.random() * Corners.length)];
        return -1;
    }

    private int fork() {
        // future state
        int[] fsGrid = Arrays.copyOf(GridStorage, GridStorage.length);
        int res;

        // Block
        for (int i : FreeCells) {
            fsGrid[i] = -this.Side;
            res = win(true, fsGrid);
            if (res != -1 && res != 100) {
                return res;
            }
            fsGrid[i] = 0;
        }

        // Build
        for (int i : FreeCells) {
            fsGrid[i] = this.Side;
            res = win(true, fsGrid);
            if (res == 100) {
                return i;
            }
            fsGrid[i] = 0;
        }

        return -1;
    }

    // Strategic set
    private int stSet() {
        if (UsedCells >= 2) {
            if (GridStorage[4] == 0) return 4;
            ArrayList<Integer> freeCorners = new ArrayList<>();
            for (int[] pair : CornerPairs) {
                if (GridStorage[pair[0]] == 0) {
                    if (GridStorage[pair[1]] == -Side) return pair[0];
                    freeCorners.add(pair[0]);
                }
            }
            if (freeCorners.size() > 0) {
                return freeCorners.get((int) Math.floor(Math.random() * freeCorners.size()));
            }
        }
        return -1;
    }

    private int win() {
        return win(false, GridStorage);
    }

    private int win(boolean forkCheck, int[] grid) {
        if (UsedCells < 3) {
            return -1;
        }

        ArrayList<Integer> blocks = new ArrayList<>();
        ArrayList<Integer> wins = null;
        if (forkCheck) wins = new ArrayList<>();
        int[] res;

        // Rows
        for (int i = 0; i < 9; i += 3) {
            res = findEmpty(i, i + 1, i + 2, grid);
            if (res[1] == this.Side) {
                if (!forkCheck) return res[0];
                else wins.add(res[0]);
            }
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // Cols
        for (int i = 0; i < 3; i++) {
            res = findEmpty(i, i + 3, i + 6, grid);
            if (res[1] == this.Side) {
                if (!forkCheck) return res[0];
                else wins.add(res[0]);
            }
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // \
        res = findEmpty(0, 4, 8, grid);
        if (res[1] == this.Side) {
            if (!forkCheck) return res[0];
            else wins.add(res[0]);
        }
        if (res[1] == -this.Side) blocks.add(res[0]);

        // /
        res = findEmpty(2, 4, 6, grid);
        if (res[1] == this.Side) {
            if (!forkCheck) return res[0];
            else wins.add(res[0]);
        }
        if (res[1] == -this.Side) blocks.add(res[0]);

        if (!forkCheck && blocks.size() > 0) {
            return blocks.get(0);
        } else if (forkCheck) {
            if (blocks.size() > 1) return blocks.get(0);
            if (wins.size() > 1) return 100;
        }
        return -1;
    }

    private int[] findEmpty(int c0, int c1, int c2) {
        return findEmpty(c0, c1, c2, GridStorage);
    }

    private int[] findEmpty(int c0, int c1, int c2, int[] grid) {
        int ch = grid[c0] + grid[c1] + grid[c2];
        if (ch == 2 || ch == -2) {
            if (grid[c0] == 0) return new int[]{c0, ch / 2};
            if (grid[c1] == 0) return new int[]{c1, ch / 2};
            if (grid[c2] == 0) return new int[]{c2, ch / 2};
        }
        return new int[]{-1, 0};
    }

    public enum AILevel {
        Beginner,
        Normal,
        Advanced,
        Expert,
        Machine
    }
}
