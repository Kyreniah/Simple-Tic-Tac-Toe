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
        for (int i = 0; i < input.length(); i+=3) {
            System.out.printf("| %c %c %c |%n",chars[i], chars[i+1], chars[i+2]);
        }

        System.out.println("---------");
    }
}
