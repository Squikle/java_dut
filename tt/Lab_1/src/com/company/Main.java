package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    private static final int bound = 9;
    private static final int rowSize = 9;
    private static final int columnSize = 9;

    public static void main(String[] args) throws Exception {
        // Створити двовимірний масив, заповнити його випадковими значеннями від 0 до 9 (Random).
        // Вивести його на екран окремим методом (private void printArray(int[][] arr)).
        // Вивести на екран всі парні числа побічної діагоналі.
        int[][] array = createArrayWithRandomNumber(4, 5);
        printArray(array);

        printNumbers(array, n -> n % 2 == 0 && n != 0); //if 0 isn't even
        printNumbers(array, n -> n % 2 == 0); //if 0 is even

        // Створити метод (private int[] fillArray(int begin, int end, int step)).
        // Який заповнює масив від begin до end, з кроком в step.
        // Приклад : fillArray(0, 10, 2) -> [0, 2, 4, 6, 8, 10] end – begin
        System.out.println(Arrays.toString(fillArray(0, 12, 3)));
    }

    private static int[][] createArrayWithRandomNumber(int rowSize, int columnSize){
        Random random = new Random();
        int[][] array = new int[rowSize][columnSize];

        for (int i = 0; i < rowSize; i++){
            for (int j = 0; j < columnSize; j++){
                array[i][j] = random.nextInt(bound);
            }
        }

        return array;
    }

    private static void printNumbers(int[][] array, Predicate<Integer> evenCondition){
        System.out.print("Numbers: ");
        for (int i = 0; i < array.length; i++){
            int number = array[i][array[i].length - i - 1];
            if (evenCondition.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printArray(int[][] array){
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[] fillArray(int begin, int end, int step) throws Exception {
        if(step == 0){
            throw new Exception("step cannot be 0");
        }
        int[] array = new int[end/step + 1];

        int temp = 0;
        for(int i = begin; i < array.length - 1; i++){
            array[i + 1] = temp += step;
        }

        return array;
    }
}