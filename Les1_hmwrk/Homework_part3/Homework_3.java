package ru.geekbrains.java_one.lesson_one.online.Homework_part3;

import java.util.Scanner;

public class Homework_3 {

    private static boolean checkNumber(int a){

        return (0<=(a));

    }
    private static int number_InputAndCheck(char input_char){
        System.out.print("Please input the number '"+ input_char + "' = ");
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
        System.out.println("Checking if the number 'a' is positive");
        System.out.println("Number 'a' must be an integer");
        int a = number_InputAndCheck('a');

        System.out.println("The statement that the number 'a' is a positive one is " + checkNumber(a));

    }
}
