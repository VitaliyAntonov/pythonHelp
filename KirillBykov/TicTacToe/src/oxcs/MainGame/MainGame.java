package oxcs.MainGame;

import java.util.Objects;
import java.util.Scanner;

public class MainGame {

    private GameGrid GGrid;
    private Scanner scanner;
    private GameState state;
    private GameMode mode;
    private PlayerSide playerSide;
    private AI.AILevel aiLevel;

    private StringBuilder stringBuilder;
    private AI Cmp;

    private boolean CleanOut = true;

    public void Start() {
        this.GGrid = new GameGrid();
        this.scanner = new Scanner(System.in);
        this.stringBuilder = new StringBuilder();
        this.state = GameState.none;
        System.out.print("""
                Welcome to Tic-Tac-Toe
                type "list" for commands
                """);
        this.Interact();
    }

    private boolean toggleCleanOut() {
        return this.CleanOut = !this.CleanOut;
    }

    private void Interact() {
        boolean exitRequested = false;
        String command;
        while (!exitRequested) {
            System.out.print("> ");
            command = scanner.nextLine();

            switch (command) {
                case "list", "ls" -> {
                    System.out.println("""

                            start|st  start the game
                            exit |ex  close the game

                            list |ls  see this list

                            lines|ln  toggle more or less output lines   [def: less]
                            clean|cl  toggle "clean" or "history" output [def: clean]
                            """);
                    continue;
                }
                case "start", "st" -> {
                    this.state = GameState.mode;
                    System.out.print("""
                            Please select playing mode:
                            1 for Player vs Computer
                            2 for Player vs Player
                            """);
                    continue;
                }
                case "exit", "ex" -> {
                    exitRequested = true;
                    this.state = GameState.none;
                    System.out.println("Bye");
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ignored) {
                    }
                }
                case "lines", "ln" -> {
                    System.out.printf("Switched to using %s%n", GGrid.toggleMoreLines() ? "more lines" : "compact grid");
                    continue;
                }
                case "clean", "cl" -> {
                    System.out.printf("Switched to using %s%n", this.toggleCleanOut() ? "clean output" : "history output");
                    continue;
                }
            }

            switch (this.state) {
                case mode -> {
                    switch (command) {
                        case "1" -> {
                            this.mode = GameMode.PVC;
                            this.state = GameState.selLevel;
                            System.out.print("""
                                    Please select Computer level (difficulty):
                                    0 Beginner
                                    1 Normal [def]
                                    2 Advanced
                                    3 Expert
                                    4 Machine
                                    """);
                            GGrid.resetGrid();
                        }
                        case "2" -> {
                            this.mode = GameMode.PVP;
                            this.state = GameState.turnX;
                            GGrid.resetGrid();
                            printBoard();
                        }
                        default -> System.out.println("Wrong input, try again");
                    }
                }
                case selLevel -> {
                    switch (command.toUpperCase()) {
                        case "0" -> {
                            this.aiLevel = AI.AILevel.Beginner;
                        }
                        case "1" -> {
                            this.aiLevel = AI.AILevel.Normal;
                        }
                        case "2" -> {
                            this.aiLevel = AI.AILevel.Advanced;
                        }
                        case "3" -> {
                            this.aiLevel = AI.AILevel.Expert;
                        }
                        case "4" -> {
                            this.aiLevel = AI.AILevel.Machine;
                        }
                        default -> this.aiLevel = AI.AILevel.Normal;
                    }
                    this.state = GameState.selSide;
                    System.out.print("""
                            Please select Player side:
                            X
                            0
                            """);
                }
                case selSide -> {
                    switch (command.toUpperCase()) {
                        case "X" -> {
                            this.playerSide = PlayerSide.X;
                            this.state = GameState.turnA;
                            this.Cmp = new AI(GGrid.getGrid(), -1, this.aiLevel);
                            printBoard();
                        }
                        case "0" -> {
                            this.playerSide = PlayerSide.N;
                            this.state = GameState.turnA;
                            this.Cmp = new AI(GGrid.getGrid(), 1, this.aiLevel);
                            makeMove("cmp");
                            printBoard();
                        }
                        default -> System.out.println("Wrong input, try again");
                    }
                }
                case turnX, turnN -> {
                    var res = makeMove(command);
                    switch (res) {
                        case fail -> System.out.println("Illegal move, try again");
                        case winX, winN -> {
                            this.state = GameState.end;
                            printBoard();
                            System.out.printf("%s won!\nPlay again? [Y/N]", res == MoveResult.winX ? 'X' : '0');
                        }
                        case draw -> {
                            this.state = GameState.end;
                            printBoard();
                            System.out.print("Draw\nPlay again? [Y/N]");
                        }
                        case normal -> {
                            if (this.state == GameState.turnX) this.state = GameState.turnN;
                            else this.state = GameState.turnX;
                            printBoard();
                        }
                    }
                }
                case turnA -> {
                    boolean brk = false;
                    for (String c : new String[]{command, "cmp"}) {
                        if (brk) break;
                        var res = makeMove(c);
                        switch (res) {
                            case fail -> {
                                System.out.println("Illegal move, try again");
                                brk = true;
                            }
                            case winX, winN -> {
                                this.state = GameState.end;
                                printBoard();
                                System.out.printf("%s won!\nPlay again? [Y/N]", (res == MoveResult.winX && this.playerSide == PlayerSide.X) || (res == MoveResult.winN && this.playerSide == PlayerSide.N) ? "You" : "Computer");
                                brk = true;
                            }
                            case draw -> {
                                this.state = GameState.end;
                                printBoard();
                                System.out.print("Draw\nPlay again? [Y/N]");
                                brk = true;
                            }
                        }
                    }
                    if (!brk) {
                        printBoard();
                    }
                }
                case end -> {
                    if ("Y".equalsIgnoreCase(command)) {
                        GGrid.resetGrid();
                        if (this.mode == GameMode.PVC) {
                            this.state = GameState.turnA;
                            if (this.playerSide == PlayerSide.N) {
                                this.Cmp = new AI(GGrid.getGrid(), 1, this.aiLevel);
                                makeMove("cmp");
                            } else {
                                this.Cmp = new AI(GGrid.getGrid(), -1, this.aiLevel);
                            }
                        } else {
                            this.state = GameState.turnX;
                        }
                        printBoard();
                    } else {
                        this.state = GameState.none;
                        System.out.print("""
                                Welcome to Tic-Tac-Toe
                                type "list" for commands
                                """);
                    }
                }
                case none -> {
                }
            }
        }
    }

    private MoveResult makeMove(String move) {
        if (this.mode == GameMode.PVC) {
            if (Objects.equals(move, "cmp")) {
                this.Cmp.updateFree(GGrid.getFreeCells());
                GGrid.setCell(this.Cmp.getMove(), this.Cmp.getSide());
            } else {
                if (!GGrid.setCell(move, this.playerSide == PlayerSide.X ? 1 : -1)) return MoveResult.fail;
            }
            return switch (GGrid.checkWin()) {
                case 1 -> MoveResult.winX;
                case -1 -> MoveResult.winN;
                case 10 -> MoveResult.draw;
                default -> MoveResult.normal;
            };
        } else if (this.mode == GameMode.PVP) {
            if (this.state == GameState.turnX) {
                if (!GGrid.setCell(move, 1)) return MoveResult.fail;
            } else if (this.state == GameState.turnN) {
                if (!GGrid.setCell(move, -1)) return MoveResult.fail;
            } else {
                return MoveResult.fail;
            }
            return switch (GGrid.checkWin()) {
                case 1 -> MoveResult.winX;
                case -1 -> MoveResult.winN;
                case 10 -> MoveResult.draw;
                default -> MoveResult.normal;
            };
        }
        return MoveResult.fail;
    }

    private void printBoard() {
        if (this.CleanOut)
            stringBuilder.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        stringBuilder.append(GGrid.getDisplayString());
        stringBuilder.append("\n\n");
        if (this.state == GameState.turnX) {
            stringBuilder.append("X turn:\n");
        } else if (this.state == GameState.turnN) {
            stringBuilder.append("0 turn:\n");
        } else if (this.state == GameState.turnA) {
            stringBuilder.append("Your turn:\n");
        }
        System.out.print(stringBuilder);
        stringBuilder.delete(0, stringBuilder.length());
    }

    private enum GameState {
        none,
        mode,
        selLevel,
        selSide,
        turnX,
        turnN,
        turnA,
        end
    }

    private enum GameMode {
        PVC,
        PVP
    }

    private enum PlayerSide {
        X,
        N
    }

    private enum MoveResult {
        fail,
        normal,
        winX,
        winN,
        draw
    }
}
