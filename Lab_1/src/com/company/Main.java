package com.company;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int arraySize = 9;

    public static void main(String[] args) {
        int[][] array = fillArray(arraySize, arraySize);

        printArray(array);
        printEvenNumbers(array);
        int[] array2 = fillArray(1, 7, 3);
        System.out.println(Arrays.toString(array2));
    }

    private static int[][] fillArray(int columns, int rows){
        Random random = new Random();
        int[][] array = new int[columns][rows];

        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                array[i][j] = random.nextInt(arraySize);
            }
        }

        return array;
    }

    private static void printEvenNumbers(int[][] array){
        System.out.print("Even numbers of the lateral diagonal of the array: ");

        for (int i = 0; i < array.length; i++){
            int columnNumber = array.length - 1 - i;
            int value = array[i][columnNumber];

            if (value != 0 && value % 2 == 0) {
                System.out.printf("%d ", value);
            }
        }

        System.out.println();
    }

    private static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] fillArray(int begin, int end, int step){
        int[] array = new int[(end - begin) / step + 1];

        int current = begin;
        for(int i = 0; current <= end; ++i){
            array[i] = current;
            current += step;
        }

        return array;
    }
}