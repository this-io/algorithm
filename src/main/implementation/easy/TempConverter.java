package main.implementation.easy;

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter in F : ");
            System.out.println("Result : " + convertToCelsius(new Scanner(System.in).nextLine()));

            System.out.println("Should we keep moving : ");

            if(new Scanner(System.in).nextLine() != "y") {
                break;
            }
        }
    }

    private static String convertToCelsius(String input) {
        if (input.isEmpty()) {
            return "Input cannot be empty.";
        }
        return String.valueOf((5 * (Double.parseDouble(input) - 32)) / 9);
    }
}
