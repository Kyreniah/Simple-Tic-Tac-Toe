package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("---------");

        /*System.out.printf("| %c %c %c |%n",input.charAt(0),input.charAt(1),input.charAt(2));
        System.out.printf("| %c %c %c |%n",input.charAt(3),input.charAt(4),input.charAt(5));
        System.out.printf("| %c %c %c |%n",input.charAt(6),input.charAt(7),input.charAt(8));*/

        /*char[] line1 = {input.charAt(0),input.charAt(1),input.charAt(2)};
        char[] line2 = {input.charAt(3),input.charAt(4),input.charAt(5)};
        char[] line3 = {input.charAt(6),input.charAt(7),input.charAt(8)};*

        String[] lines = {line1,line2,line3};*/
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i += 3) {
            System.out.printf("| %c %c %c |%n", chars[i], chars[i + 1], chars[i + 2]);
        }

        System.out.println("---------");
        boolean xWins = false;
        boolean oWins = false;
        //X wins horizontal
        for (int i = 0; i < input.length(); i += 3) {
            if (chars[i] == 'X' && chars[i + 1] == 'X' && chars[i + 2] == 'X') {
                xWins = true;
                break;
            }
        }
        //X wins vertical
        for (int i = 0; i < 3; i++) {
            if (chars[i] == 'X' && chars[i+3] == 'X' && chars[i+6] == 'X') {
                xWins = true;
                break;
            }
        }
        //X wins diagonal
        if (chars[0] == 'X' && chars[4] == 'X' && chars[8] == 'X' || chars[2] == 'X' && chars[4] == 'X' && chars[6] == 'X') {
            xWins = true;
        }
        //O wins horizontal
        for (int j = 0; j < input.length(); j += 3) {
            if (chars[j] == 'O' && chars[j + 1] == 'O' && chars[j + 2] == 'O') {
                oWins = true;
                break;
            }
        }
        //O wins vertical
        for (int i = 0; i < 3; i++) {
            if (chars[i] == 'O' && chars[i+3] == 'O' && chars[i+6] == 'O') {
                oWins = true;
                break;
            }
        }
        //O wins diagonal
        if (chars[0] == 'O' && chars[4] == 'O' && chars[8] == 'O' || chars[2] == 'O' && chars[4] == 'O' && chars[6] == 'O') {
            xWins = true;
        }
        //difference between number of Xs and Os
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
}
