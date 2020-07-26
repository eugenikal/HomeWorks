package ru.geekbrains.java_one.lesson_one.online.Homework_part4;

import java.util.Scanner;

public class Homework_4 {


    private static String Name_InputAndCheck(){
        System.out.print("Please input the name for greetings = ");
        Scanner scaner = new Scanner(System.in);

        String inputName = scaner.nextLine();
        return inputName;

    }

    public static void main(String[] args) {

        String Name = Name_InputAndCheck();
        System.out.println("Привет, " + Name + '!');

    }
}
