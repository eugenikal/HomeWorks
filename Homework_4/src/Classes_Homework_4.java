public class Classes_Homework_4 {

    private static void for_over45_salaryUp(Employee[] Staff){ // make salary increased for 5000 for all employees older than 45
        for(int i = 0; i < Staff.length; i++) {
            if (Staff[i].getEmployee_age() > 45) { //check the age
                Staff[i].setSalary(Staff[i].getEmployee_salary()+ 5000); //make salary increased for 5000
            }
        }
    }

    private static double average_Staffage (Employee[] Staff){
        double average_age = 0;
        for(int i = 0; i < Staff.length; i++) {
            average_age += 1.0*Staff[i].getEmployee_age() / Staff.length;
        }
        return average_age;

    }

    private static double average_Staffsalary (Employee[] Staff){
        double average_salary = 0;
        for(int i = 0; i < Staff.length; i++) {
            average_salary += Staff[i].getEmployee_salary() / Staff.length;
        }
        return average_salary;

    }

    public static void main(String[] args){

        Employee[] MyCompanyStaff = new Employee[5];
        MyCompanyStaff[0] = new Employee ("Regina",10000,37);
        MyCompanyStaff[1] = new Employee ("Petr",7000,65);
        MyCompanyStaff[2] = new Employee ("Ivan",2000,23);
        MyCompanyStaff[3] = new Employee ("Irina Nikolaevna",10000,62);
        MyCompanyStaff[4] = new Employee ("Irina Nikolaevna",10000,62);

        for(int i = 0; i<MyCompanyStaff.length; i++){
            System.out.print("Employee " + (i+1) +" name is "+ MyCompanyStaff[i].getEmployee_name()
                    + ", age is " + MyCompanyStaff[i].getEmployee_age());
            System.out.println(" Salary = " + MyCompanyStaff[i].getEmployee_salary());
            if(i == MyCompanyStaff.length-1)
                System.out.println("---------------- end of employee list -------------------");
        }

        for_over45_salaryUp(MyCompanyStaff);

        for(int i = 0; i<MyCompanyStaff.length; i++){
            System.out.print("Employee " + (i+1) +" name is "+ MyCompanyStaff[i].getEmployee_name()
                    + ", age is " + MyCompanyStaff[i].getEmployee_age());
            System.out.println(" Salary = " + MyCompanyStaff[i].getEmployee_salary() + " ID = " + MyCompanyStaff[i].getEmployee_ID());
        }

        System.out.println(" Average Salary = " + average_Staffsalary(MyCompanyStaff));
        System.out.println(" Average Age = " + average_Staffage(MyCompanyStaff));
    }
}
