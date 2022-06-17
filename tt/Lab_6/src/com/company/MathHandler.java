package com.company;

import java.util.Arrays;

public class MathHandler {

    private static String errorMessage =
            "The mathematical string you entered is not correct and cannot be processed by the program.";

    public static double Execute(String mathString) throws Exception {
        if(mathString.length() < 2){
            throw new Exception(errorMessage);
        }

        String[] numbers = mathString.split("[+\\-*/]");
        String[] operations = mathString.split("\\d");
        operations = Arrays.copyOfRange(operations, 1, operations.length);

        if(numbers.length - 1 != operations.length){
            throw new Exception(errorMessage);
        }

        double result = Double.parseDouble(numbers[0]);
        for (int i = 0; i < operations.length; i++) {
            result = DoOperation(operations[i], result, Double.parseDouble(numbers[i+1]));
        }

        return result;
    }

    private static double DoOperation(String operation, double firstNumber, double secondNumber){
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> 0;
        };
    }
}
