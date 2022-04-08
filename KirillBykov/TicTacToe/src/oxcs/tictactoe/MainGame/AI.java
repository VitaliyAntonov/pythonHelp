package oxcs.tictactoe.MainGame;

import java.util.*;

public class AI {

    private final int[] GridStorage;
    private final int Side;
    private final int[] Corners = {0, 2, 6, 8};
    private final int[][] CornerPairs = {{0, 8}, {2, 6}, {6, 2}, {8, 0}};
    private int UsedCells = 0;
    private int[] FreeCells = new int[9];

    private double level;

    public AI(int[] grid, int side, AILevel level) {
        this.GridStorage = grid;
        this.Side = side;
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
        return this.FreeCells[(int) Math.floor(Math.random() * this.FreeCells.length)];
    }

    public void updateFree(int[] freeCells) {
        this.FreeCells = freeCells;
        this.UsedCells = 9 - freeCells.length;
    }

    private int first() {
        if (this.UsedCells == 1 && this.GridStorage[4] == 0) return 4;
        else if (this.UsedCells <= 1) return this.Corners[(int) Math.floor(Math.random() * this.Corners.length)];
        return -1;
    }

    private int fork() {
        // future state
        int[] fsGrid = Arrays.copyOf(this.GridStorage, this.GridStorage.length);
        int[] fsGridDeep = Arrays.copyOf(this.GridStorage, this.GridStorage.length);
        Set<Integer> preList = new HashSet<>();
        Set<Integer> blockReq = new HashSet<>();
        Map<Integer, Integer> forcedCell = new HashMap<>();
        List<Integer> resList;
        List<Integer> deepWinRes;
        int res;

        // Block
        for (int i : this.FreeCells) {
            fsGrid[i] = -this.Side;
            deepWinRes = deepWin(fsGrid);
            if (deepWinRes != null && deepWinRes.get(0) != 100) {
                blockReq.add(i);
                for (int block : deepWinRes) {
                    fsGridDeep[block] = this.Side;
                    res = win(fsGridDeep);
                    if (res != -1 && res != i) {
                        preList.add(block);
                        forcedCell.put(block, res);
                    }
                    fsGridDeep[block] = 0;
                }
            }
            fsGrid[i] = 0;
        }
        if (preList.size() > 0) {
            resList = new ArrayList<>();
            for (int mv : preList) {
                if (!blockReq.contains(forcedCell.get(mv))) {
                    resList.add(mv);
                }
            }
            if (resList.size() > 0) return resList.get((int) Math.floor(Math.random() * resList.size()));
        }

        // Build
        resList = new ArrayList<>();
        for (int i : this.FreeCells) {
            fsGrid[i] = this.Side;
            deepWinRes = deepWin(fsGrid);
            if (deepWinRes != null && deepWinRes.get(0) == 100) {
                resList.add(i);
            }
            fsGrid[i] = 0;
        }
        if (resList.size() > 0) return resList.get((int) Math.floor(Math.random() * resList.size()));

        return -1;
    }

    // Strategic set
    private int stSet() {
        if (this.UsedCells >= 2) {
            if (this.GridStorage[4] == 0) return 4;
            ArrayList<Integer> freeCorners = new ArrayList<>();
            for (int[] pair : this.CornerPairs) {
                if (this.GridStorage[pair[0]] == 0) {
                    if (this.GridStorage[pair[1]] == -this.Side) return pair[0];
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
        return win(this.GridStorage);
    }

    private int win(int[] grid) {
        if (this.UsedCells < 3) {
            return -1;
        }

        ArrayList<Integer> blocks = new ArrayList<>();
        int[] res;

        // Rows
        for (int i = 0; i < 9; i += 3) {
            res = findEmpty(i, i + 1, i + 2, grid);
            if (res[1] == this.Side) return res[0];
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // Cols
        for (int i = 0; i < 3; i++) {
            res = findEmpty(i, i + 3, i + 6, grid);
            if (res[1] == this.Side) return res[0];
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // \
        res = findEmpty(0, 4, 8, grid);
        if (res[1] == this.Side) return res[0];
        if (res[1] == -this.Side) blocks.add(res[0]);

        // /
        res = findEmpty(2, 4, 6, grid);
        if (res[1] == this.Side) return res[0];
        if (res[1] == -this.Side) blocks.add(res[0]);

        if (blocks.size() > 0) {
            return blocks.get(0);
        }
        return -1;
    }

    private List<Integer> deepWin(int[] grid) {
        if (this.UsedCells < 3) {
            return null;
        }

        ArrayList<Integer> blocks = new ArrayList<>();
        ArrayList<Integer> wins = new ArrayList<>();
        int[] res;

        // Rows
        for (int i = 0; i < 9; i += 3) {
            res = findEmpty(i, i + 1, i + 2, grid);
            if (res[1] == this.Side) wins.add(res[0]);
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // Cols
        for (int i = 0; i < 3; i++) {
            res = findEmpty(i, i + 3, i + 6, grid);
            if (res[1] == this.Side) wins.add(res[0]);
            if (res[1] == -this.Side) blocks.add(res[0]);
        }

        // \
        res = findEmpty(0, 4, 8, grid);
        if (res[1] == this.Side) wins.add(res[0]);
        if (res[1] == -this.Side) blocks.add(res[0]);

        // /
        res = findEmpty(2, 4, 6, grid);
        if (res[1] == this.Side) wins.add(res[0]);
        if (res[1] == -this.Side) blocks.add(res[0]);

        if (blocks.size() > 1) return blocks;
        if (wins.size() > 1) return List.of(100);

        return null;
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
