package ru.geekbrains.java_one.lesson_one.online.Homework_part1;

import java.util.Scanner;

public class Homework_1 {

    private static void ArithmeticResult(int a, int b,int c,int d){

        float Result = a * (b +((float) c / d));
        System.out.println("Expression " + a + " * (" + b + " + ("+ c +"/"+ d + ")) is equal to "+ Result);
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
        System.out.println("Calculation of expression a * (b + (c / d))");
        System.out.println("Numbers a, b, c and d must be integers");
        int a = number_InputAndCheck('a');
        int b = number_InputAndCheck('b');
        int c = number_InputAndCheck('c');
        int d = number_InputAndCheck('d');
        ArithmeticResult(a,b,c,d);

    }
}
