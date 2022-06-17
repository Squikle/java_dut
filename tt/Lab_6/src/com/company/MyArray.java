package com.company;

public class MyArray {
    public static int[] fillArray(double size){
        int[] array = new int[(int)size];
        int middleIndex = (int) Math.floor(size/2);

        for (int i = middleIndex; i >= 0; i--) {
            array[i] = middleIndex - i;
        }

        for (int i = middleIndex + 1; i < array.length; i++) {
            array[i] = i - middleIndex;
        }

        return array;
    }
}
