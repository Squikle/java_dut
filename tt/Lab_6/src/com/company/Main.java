package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Result = " + MathHandler.Execute(new Scanner(System.in).nextLine()));
        System.out.println(Arrays.toString(MyArray.fillArray(11)));
        NameDb.Start();
    }
}
