package online.Homework_lesson2;

import java.util.Arrays;

public class Homework_2 {
    /*1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    */
    private static void BitArray_Inversion(byte[] array){
        int arr_length = array.length;
        for(int i=0;i<arr_length;i++){
            array[i] = (byte) ((array[i]==0) ? 1 : 0);
        }
    }

    /*2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    */
    private static void FillArray_1_step_3(int[] array){
        for(int i=0;i<8;i++){
            array[i] = (i==0) ? 1 : array[i-1]+3;
        }
    }

    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;*/
    private static void Double_Less6_Values(int[] array){
        for(int i=0;i<12;i++){
            array[i]=(array[i]<6) ? 2*array[i] : array[i];
        }
    }
    /*4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;*/
    private static void SearchMin(double[] array){
        double Min=0;
        for(int i=0;i<array.length;i++){
            Min=(Min>array[i]) ? array[i] : Min;
        }
        //System.out.println("Task 4 array minimum value is : " + Min); //checking of task 4 Min
    }
    private static void SearchMax(double[] array){
        double Max=0;
        for(int i=0;i<array.length;i++){
            Max=(Max<array[i]) ? array[i] : Max;
        }
        //System.out.println("Task 4 array maximum value is : " + Max); //checking of task 4 Max
    }

    /*5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);*/
    private static void DiagValuesAssignto1(){
        int[][] array = new int[10][10];
        for(int i=0;i<10;i++){
            array[i][i]=1;
        }
        //checking of task 5
        //for(int x=0;x<10;x++) {
        //System.out.println(" " + Arrays.toString(array[x]));
        //}
    }

    /*6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место,
    в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, 1, 2, 3, 4]) → true.
     */

    private static boolean Balance_Found(int[] array){
        double SumLeft=0; double GrandSum=0;

        for(int i=0; i<array.length;i++) {
                GrandSum+=array[i];                                         //calculate all array values sum -> GrandSum
        }
        for(int i=1; (i<array.length) && (2*SumLeft<=GrandSum);i++) {
            SumLeft=0;
            for (int sl=0; sl<i; sl++) {
                SumLeft += array[sl];
            }
        }                                                                   // calculate left part sum ->SumLeft and check the Term (2*SumLeft!=GrandSum), continue while false
        return (2*SumLeft==GrandSum);
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    //сделал двумя способами, первый быстрее на больших n
    private static int[] ArrayRotation_v1(int[] arr, int n) {

        if (n >0){
            n = (n >= arr.length) ? n % arr.length : n;                                 //check multiplicity
        }else
        if (n <0){
            n = (-n >= arr.length) ? arr.length + (n % arr.length) : n+arr.length;      //check multiplicity and make n positive(if needed)
        }
        int hand;                                                                       //exchange helper, since no other array allowed

        if (n!=0) {                                                                     //check if rotation is needed at all
            for (int turn = 0; turn < n; turn++) {                                      //make it roll n times or no roll at all in case n=0
                for (int i = 1; i < arr.length; i++) {
                    hand = arr[i];
                    arr[i]=arr[0];
                    arr[0] = hand;
                }                                                                       // one time roll end
            }
        }   else {
            System.out.println("NO NEED TO ROTATE since rotated array is equal to original one : ");
        }


        return arr;                                                                     //return array rotated n times
    }

    private static int[] ArrayRotation_v2(int[] arr, int n) {
        int direction = (n >= 0) ? 1 : (-1);                //where to roll, to the left(n<0) or to the right(n>0), =0 included to make direction valued in this case too
        int start_position = (n > 0) ? 1 : (arr.length-1);  //array's element to start roll with (first for right roll, last for left roll)
        int hand;                                           //exchange helper, since no other array allowed
        n *= direction;                                     //take absolute n, since no abs() is known

            if ((n!=0) && (n % arr.length!=0)) {            //check if rotation is needed at all
                for (int turn = 0; turn < n; turn++) {      //make it roll n times or no roll at all
                    for (int i = start_position; (i > 0) && (i < arr.length); i+=direction) {
                        hand = arr[i];
                        arr[i]=arr[0];
                        arr[0] = hand;
                    }                                       // one time array roll end
                }
            }   else {
                    System.out.println("NO NEED TO ROTATE since rotated array is equal to original one!");
                }


        return arr;                                         //return array rotated n times
    }



    public static void main(String[] args) {

        //***Task 1***

        System.out.println("Task 1");
        byte[] Task1Arr = {1,1,1,0,0,0,1,1,1};
        BitArray_Inversion(Task1Arr);
        System.out.println("Inverted Array : " + Arrays.toString(Task1Arr)); //checking of task 1
        System.out.println();

        //***Task 2***

        System.out.println("Task 2");
        int[] Task2Arr = new int[8];
        FillArray_1_step_3(Task2Arr);
        System.out.println("Filled in Array is : " + Arrays.toString(Task2Arr)); //checking of task 2
        System.out.println();

        //***Task 3***

        System.out.println("Task 3");
        int[] Task3Array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Double_Less6_Values(Task3Array);
        System.out.println("Amended Task 3 Array is : " + Arrays.toString(Task3Array)); //checking of task 3
        System.out.println();

        //***Task 4***

        //System.out.println("Task 4");
        double[] Task4Array = {0,1,1.2,123,230,89,57,25.2,123.1,-123};
        SearchMin(Task4Array);
        SearchMax(Task4Array);
        //System.out.println();

        //***Task 5***

        //System.out.println("Task 5");
        DiagValuesAssignto1();
        //System.out.println();

        //***Task 6***

        System.out.println("Task 6");
        int[] Task6Arr = {-1,2,3,4,5,6,19,38};
        System.out.println("Balance exists -> " + Balance_Found(Task6Arr));
        System.out.println();

        //***Task7***

        System.out.println("Task 7 ver.1");
        int[] Task7Arr = {1,2,3,4,5,6};
        int n=-20;
        System.out.println("Original Array is : " + Arrays.toString(Task7Arr)); //checking of task 7
        System.out.println("Value n is        : " + n);
        System.out.println("Rotated Array is  : " + Arrays.toString(ArrayRotation_v1(Task7Arr, n)));
        System.out.println();

        //***Task7*** ver.2

        System.out.println("Task 7 ver.2");
        Task7Arr = new int[]{1, 2, 3, 4, 5, 6};
        int nn=-14;
        System.out.println("Original Array is : " + Arrays.toString(Task7Arr)); //checking of task 7
        System.out.println("Value n is        : " + nn);
        System.out.println("Rotated Array is  : " + Arrays.toString(ArrayRotation_v2(Task7Arr, nn)));
    }
}
