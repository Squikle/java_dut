package com.company;

import java.util.Scanner;

public class NameDb {
    private static String namesString = "";

    public static void Start(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome.");
        boolean isStart = true;
        while (isStart){
            System.out.print("1. Enter new value \n2. Display all names \n3. Exit\nEnter ur code: ");
            switch (scanner.next()) {
                case "1" -> {
                    System.out.print("Enter +Name if add -Name if remove: ");
                    handleInput(scanner.next());
                }
                case "2" -> displayNames();
                case "3" -> isStart = false;
                default -> System.out.println("There is no such command.");
            }
        }
    }

    private static void handleInput(String input){
        char operand = input.charAt(0);
        if(operand == '+'){
            add(input);
        }
        else if(operand == '-'){
            remove(input);
        }
        else{
            System.out.println("I don’t understand what needs to be done.");
        }
    }

    private static void add(String name){
        name = name.substring(name.lastIndexOf("+") + 1);
        namesString += name + ",";
    }

    private static void remove(String name) {
        name = name.substring(name.lastIndexOf("-") + 1);
        if(!namesString.contains(name)){
            System.out.println("There's no such name.");
            return;
        }

        namesString = namesString.replace(name + ",", "");
    }

    private static void displayNames(){
        int length =  namesString.length();
        System.out.println(namesString.substring(0, length-1));
    }
}
