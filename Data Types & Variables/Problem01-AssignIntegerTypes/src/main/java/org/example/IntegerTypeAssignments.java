package org.example;

import java.util.Scanner;

public class IntegerTypeAssignments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                long num = Long.parseLong(input);

                if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                    byte value = (byte) num;
                    System.out.println("byte: " + value);
                } else if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
                    short value = (short) num;
                    System.out.println("short: " + value);
                } else if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
                    int value = (int) num;
                    System.out.println("int: " + value);
                } else {
                    System.out.println("long: " + num);
                }
            } catch (NumberFormatException e) {
                System.out.println("string: " + input);
            }
        }

        scanner.close();
    }
}

