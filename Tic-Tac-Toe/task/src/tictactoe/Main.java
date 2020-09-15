package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "_________";
        char[][] field = buildField(input);
        printField(field);
        // play
        boolean validMove = false;
        int turn = 1; // 1 = X, -1 = O
        String gameState = "Game not finished";
        do {
            System.out.println((turn == 1 ? "X" : "O") + " turn!");
            System.out.print("Enter the coordinates: ");
            int cellX = 0;
            int cellY = 0;
            // validate input
            // TODO: replace try-catch with: scanner.hasNextInt()
            try {
                cellX = scanner.nextInt();
                cellY = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("You should enter numbers!");
                continue;
            }
            // check range
            if (cellX > 3 || cellX < 1 || cellY > 3 || cellY < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            // check empty cell
            int i = 3 - cellY;
            int j = cellX - 1;
            if (field[i][j] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            validMove = true;
            field[i][j] = turn == 1 ? 'X' : 'O';
            printField(field);
            gameState = gameState(field);
            turn *= -1; // switch turn
        } while (!validMove || gameState.equals("Game not finished"));
        System.out.println(gameState);
        ;
    }

    private static char[][] buildField(String input) {
        char[][] field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = input.charAt(i * 3 + j);
            }
        }
        return field;
    }

    private static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static String gameState(char[][] field) {
        int[] sumOfThree = new int[8];
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 'X') {
                    xCount++;
                }
                if (field[i][j] == 'O') {
                    oCount++;
                }
                // sum of rows
                if (i == 0) {
                    sumOfThree[0] += field[0][j];
                }
                if (i == 1) {
                    sumOfThree[1] += field[1][j];
                }
                if (i == 2) {
                    sumOfThree[2] += field[2][j];
                }
                // sum of columns
                if (j == 0) {
                    sumOfThree[3] += field[i][0];
                }
                if (j == 1) {
                    sumOfThree[4] += field[i][1];
                }
                if (j == 2) {
                    sumOfThree[5] += field[i][2];
                }
                // sum of diagonals
                if (i == j) { // main
                    sumOfThree[6] += field[i][j];
                }
                if (i + j == 2) { // sec
                    sumOfThree[7] += field[i][j];
                }
            }
        }

        boolean xWins = false;
        boolean oWins = false;
        for (int s : sumOfThree) {
            if (s == 264) { // (X=88) * 3
                xWins = true;
                continue;
            }
            if (s == 237) { // (O=79) * 3
                oWins = true;
            }
        }
        // analyse
        boolean draw = xCount + oCount == 9 && !xWins && !oWins;
        boolean impossible = xWins && oWins || Math.abs(xCount - oCount) > 1;

        if (draw) {
            return "Draw";
        } else if (impossible) {
            return "Impossible";
        } else if (xWins) {
            return "X wins";
        } else if (oWins) {
            return "O wins";
        } else {
            return "Game not finished";
        }
    }

}
