package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final int N = 10;
    private static final int randomBound = 10;
    private static final String testString = "sjdhgfsjkavchjwagehf";

    public static void main(String[] args) {
        //task 1
        taskOne();

        //task 2
        int[] array = fillRandomNumbers(N, randomBound);
        //Arrays.stream(array).forEach(System.out::println);
        System.out.println("Average Of All Even Numbers: " + AverageOfAllEvenNumbers(array));

        //task 3
        System.out.println(stringHandler(testString));

        //task 4
        //Already implemented in Lab2

        //task 5
        List<User> users = Arrays.asList(
                new User("User 1", 15, "test1@gmail.com"),
                new User("User 2", 19, "test2@gmail.com"),
                new User("User 3", 30, "test3@gmail.com"),
                new User("User 4", 12, "test4@gmail.com"),
                new User("User 5", 34, "test5@gmail.com")
        );

        List<UserDto> userDtos = users.stream().filter(user -> user.age > 18).map(UserMapper::mapToDto).toList();
    }

    private static void taskOne(){
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.charAt(0) == 'c')
                .sorted().map(s -> s.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);
    }

    private static int[] fillRandomNumbers(int size, int bound){
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }

        return array;
    }

    private static int AverageOfAllEvenNumbers(int[] array){
        return (int) Arrays.stream(array).filter(value -> value % 2 == 0).average().getAsDouble();
    }

    private static String stringHandler(String s){
        return s.chars().mapToObj(c -> {
            if(c >= 104 && c < 116){
                return String.valueOf((char) (c - 32));
            }

            return String.valueOf((char) c);
        }).collect(Collectors.joining());
    }
}
