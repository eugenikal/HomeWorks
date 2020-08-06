import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Employee {

    private String name;
    private double salary;
    private int age;
    private String uniqueID;



    public void setSalary(double salary){
        this.salary = salary;
    }

    final Random random = new Random();

    Employee(String Employee_name, double Employee_salary, int Employee_age){
        name = Employee_name;
        salary = Employee_salary;
        age = Employee_age;

        char[] temp = name.toCharArray();
        char[] temp1 = new char[(temp.length)];
        for(int i = 0; i < name.length(); i++) {
            if (i % 2 == 0) {
                temp1[i] = temp[i];
            } else
            {temp1[i] = (char)random.nextInt(566+1);}
        }
        uniqueID = Arrays.toString(temp1);

    }
    /* ------------------ GETTERS BLOCK START-----------------------------------*/
    public String getEmployee_name(){
        return name;
    }

    public double getEmployee_salary(){
        return salary;
    }

    public int getEmployee_age(){
        return age;
    }

    public String getEmployee_ID(){
        return uniqueID;
    }
    /* ------------------ GETTERS BLOCK END-----------------------------------*/



}
