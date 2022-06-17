package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception
    {
        int uniqueNumber = findNumber(new int[] { 2, 2, 2, 1, 2, 2 });
        System.out.println("Task 1: " + uniqueNumber);

        var array = secondTask(new int[] { 5, 3, 2, 8, 1, 4 });
        System.out.println("Task 2: " + Arrays.toString(array));
    }

    private static int findNumber(int[] array) throws Exception
    {
        var uniqueNumberValue = findUniqueNumberValue(array);
        for (int j : array) {
            if (j != uniqueNumberValue) {
                return j;
            }
        }

        throw new Exception("Couldn't find unique number");
    }

    private static int findUniqueNumberValue(int[] array)
    {
        int uniqueValue = array[0];
        if (uniqueValue != array[1]) {
            if (uniqueValue != array[2]) {
                uniqueValue = array[2];
            }
        }
        return uniqueValue;
    }

    private static int[] secondTask(int[] array)
    {
        if(array == null || array.length == 0){
            return array;
        }

        int[] oddNumbers = Arrays.stream(array)
                .filter(Main::isNumberOdd)
                .sorted()
                .toArray();

        for (int i = 0, j = 0; i < array.length; i++) {
            if(isNumberOdd(array[i])) {
                array[i] = oddNumbers[j++];
            }
        }

        return array;
    }

    private static boolean isNumberOdd(int number) {
        return number % 2 != 0 || number == 0;
    }
}
