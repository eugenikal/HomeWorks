package ru.geekbrains.java_one.lesson_one.online.Homework_part2;

import java.util.Scanner;

public class Homework_2 {

    private static boolean checkSum2numbers(int a, int b){

        return ((10<=(a+b)) && ((a+b)<=20));

    }
    private static int number_InputAndCheck(char input_char){
        System.out.print("Please input the number "+ input_char + " = ");
        Scanner scaner = new Scanner(System.in);
        //fault with check...
        /*boolean check_In = true;
        while (check_In) {
                if (!scaner.hasNextInt()) {
                    System.out.println("Please input correct number");
                    Scanner scaner = new Scanner(System.in);
            } else{

                    check_In = false;
            }
        }*/
        int number = scaner.nextInt();
        return number;

    }

    public static void main(String[] args) {
        System.out.println("Checking if the sum of a and b is in range from 10 to 20 (including)");
        System.out.println("Numbers a and b must be integers ones");
        int a = number_InputAndCheck('a');
        int b = number_InputAndCheck('b');
        System.out.println("The result is " + checkSum2numbers(a,b));

    }
}
