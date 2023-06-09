package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = fillBoard(3,3);
        printBoard(board);

        int[] move = getInput2();
        addMove(board, move);

        boolean xWins = hasWinningCondition(board, 'X');
        boolean oWins = hasWinningCondition(board, 'O');
        //evaluateGame(board,xWins,oWins);
    }
    public static char[][] fillBoard(int n, int m) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        char[][] board = new char[n][m];

        for (int i = 0; i < chars.length;) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    board[j][k] = chars[i];
                    i++;
                }
            }
        }
        return board;
    }
    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int n;
        int m;
        int [] move = new int[2];
        while (!validInput) {
            String first = sc.next();
            String second = sc.next();
            if (!(isStringInt(first) && isStringInt(second))) {
                System.out.println("You should enter numbers!");
                continue;
            }
            n = Integer.parseInt(first);
            m = Integer.parseInt(second);
            if (n < 1 || n > 3 || m < 1 || m > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                validInput = true;
                move[0] = n;
                move[1] = m;
            }
        }
        return move;
    }
    public static int[] getInput2() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int [] move = new int[2];
        while (!validInput) {
            for (int i = 0; i < 2; i++) {
                if (sc.hasNextInt()) {
                    move[i] = sc.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    sc.nextLine();
                    break;
                }
            } if (move[0] < 1 || move[0] > 3 || move[1] < 1 || move[1] > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                validInput = true;
            }
        }
        return move;
    }
    public static void addMove(char[][] board, int[] move) {
        while (!(board[move[0] - 1][move[1] - 1] == '_')) {
            System.out.println("This cell is occupied! Choose another one!");
            move = getInput2();
        }
        board[move[0] - 1][move[1] - 1] = 'X';
        printBoard(board);
    }
    public static boolean allCharactersEqual(char[] chars, char c) {
        for (char aChar : chars) {
            if (aChar != c) {
                return false;
            }
        }
        return true;
    }
    public static boolean hasWinningCondition(char[][] game, char c) {
        boolean playerWins = false;
        //Player wins horizontal
        for (char[] line : game) {
            if (allCharactersEqual(line, c)) {
                playerWins = true;
                break;
            }
        }
        //Player wins vertical
        for (int i = 0; i < game.length; i++) {
            char[] column = new char[game.length];
            for (int j = 0; j < game[i].length; j++) {
                    column[j] = game[j][i];
            }
            if (allCharactersEqual(column, c)) {
                playerWins = true;
                break;
            }
        }
        //Player wins diagonal
        if (game[0][0] == c && game[1][1] == c && game[2][2] == c || game[2][0] == c && game[1][1] == c && game[0][2] == c) {
            playerWins = true;
        }
        return playerWins;
    }
    public static boolean hasWinningCondition2(char[][] game, char c) {
        boolean playerWins = false;
        //Player wins horizontal
        for (int i = 0; i < game.length; i += 3) {
            if (game[i][0] == c && game[i][1] == c && game[i][2] == c) {
                playerWins = true;
                break;
            }
        }
        //Player wins vertical
        for (int i = 0; i < game[i].length; i++) {
            if (game[0][i] == c && game[1][i] == c && game[2][i] == c) {
                playerWins = true;
                break;
            }
        }
        //Player wins diagonal
        if (game[0][0] == c && game[1][1] == c && game[2][2] == c || game[2][0] == c && game[1][1] == c && game[0][2] == c) {
            playerWins = true;
        }
        return playerWins;
    }
    public static void evaluateGame(char[][] board, boolean xWins, boolean oWins) {
        int numberOfX = 0;
        int numberOfO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    numberOfX++;
                } else if (board[i][j] == 'O') {
                    numberOfO++;
                }
            }
        }
        int difference = Math.abs(numberOfX - numberOfO);

        if((xWins && oWins) || (1 < difference)) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (Arrays.deepToString(board).contains("_")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }
}
