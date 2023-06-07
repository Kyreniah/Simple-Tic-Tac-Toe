package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();

        System.out.println("---------");
        for (int i = 0; i < input.length(); i += 3) {
            System.out.printf("| %c %c %c |%n", chars[i], chars[i + 1], chars[i + 2]);
        }
        System.out.println("---------");

        boolean xWins = hasWinningCondition(chars, 'X');
        boolean oWins = hasWinningCondition(chars, 'O');

        //Difference between number of Xs and Os
        int numberOfX = 0;
        int numberOfO = 0;
        for (int i = 0; i < input.length(); i++) {
            if (chars[i] == 'X') {
                numberOfX++;
            } else if (chars[i] == 'O') {
                numberOfO++;
            }
        }
        int difference = Math.abs(numberOfX - numberOfO);
        //Final evaluation
        if((xWins && oWins) || (1 < difference)) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (new String(chars).contains("_")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }

    }
    public static boolean hasWinningCondition(char[] game, char c) {
        boolean playerWins = false;
        //Player wins horizontal
        for (int i = 0; i < game.length; i += 3) {
            if (game[i] == c && game[i + 1] == c && game[i + 2] == c) {
                playerWins = true;
                break;
            }
        }
        //Player wins vertical
        for (int i = 0; i < 3; i++) {
            if (game[i] == c && game[i + 3] == c && game[i + 6] == c) {
                playerWins = true;
                break;
            }
        }
        //Player wins diagonal
        if (game[0] == c && game[4] == c && game[8] == c || game[2] == c && game[4] == c && game[6] == c) {
            playerWins = true;
        }
        return playerWins;
    }
}
