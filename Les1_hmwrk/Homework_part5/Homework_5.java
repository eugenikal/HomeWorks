package ru.geekbrains.java_one.lesson_one.online.Homework_part5;

import java.util.Scanner;

public class Homework_5 {

    private static boolean checkYear(int year){
        boolean result = true;
        if (((year%4!=0) || (year%100==0)) && (year%400!=0)){
            result = false;
            }
        return (result);

    }
    private static int number_InputAndCheck(){
        System.out.print("Please input the Year = ");
        Scanner scaner = new Scanner(System.in);
        //fault with check below...
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
        System.out.println("Checking if the year is a leap one");
        System.out.println("Year number must be positive and integer");
        int year = number_InputAndCheck();

        System.out.println("The statement that the year "+year+" is a leap one is " + checkYear(year));

    }
}
