package com.company;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) {
        findNumber(generateVeryBigArray());
        //System.out.println(Arrays.toString(mySort(new int[]{5,3,2,0,1,4,4,7,12,3})));

    }

    private static int[] generateVeryBigArray(){
        int size = new Random().nextInt(100000, 1000000);
        int foundNumber =  new Random().nextInt(0, size);

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            if(i == foundNumber){
                array[i] = 6;
                continue;
            }
            array[i] = 3;
        }

        return array;
    }

    private static void findNumber(int[] array){
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(!hashset.contains(array[i])){
                if(hashset.size() == 1 && i == 1){
                    if(array[i] == array[i + 1]){
                        displayFindNumber(array[i - 1]);
                        break;
                    }
                    else{
                        displayFindNumber(array[i]);
                    }
                }
                else if(hashset.size() == 1){
                    displayFindNumber(array[i]);
                    break;
                }
                hashset.add(array[i]);
            }
        }
        System.out.println(Calendar.getInstance().getTimeInMillis() - timeInMillis);
    }

    private static boolean finder(int a, int b){
        return (a ^ b) != 0;
    }

    private static void displayFindNumber(int number){
        System.out.println("You were looking for this number " + number);
    }

    private static int[] mySort(int[] array){
        if(array == null || array.length == 0){
            return array;
        }

        int[] tempArray =
                Arrays.stream(array)
                .filter(operand -> operand % 2 != 0 || operand == 0)
                .toArray();

        Arrays.sort(tempArray);

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0 || array[i] == 0){
                array[i] = tempArray[j++];
            }
        }

        return array;
    }
}
