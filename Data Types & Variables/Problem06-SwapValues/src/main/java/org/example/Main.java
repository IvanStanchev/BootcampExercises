package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a = 14;
        int b = 32;
        System.out.println("Before swapping:");
        print(a,b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping:");
        print(a,b);


    }
    public static void print(int a, int b){
        System.out.println("a = " + a);
        System.out.println("b = " + b + "\n");
    }
}