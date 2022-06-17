package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();

        fifthTask();
    }

    private static void firstTask()
    {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.charAt(0) == 'c')
                .sorted()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);
    }

    private static void secondTask()
    {
        int[] array = createArrayWithRandomFill(10, 10);
        var averageOfAllEvenNumbers = Arrays
                .stream(array)
                .filter(value -> value % 2 == 0)
                .average()
                .orElse(0);
        System.out.printf("Average Of All Even Numbers: %f", averageOfAllEvenNumbers);
        System.out.println();
    }

    private static void thirdTask() {
        var result = "sjdhgfsjkavchjwagehf"
                .chars()
                .mapToObj(c -> {
                    if (c >= 104 && c < 116) {
                        return String.valueOf((char) (c - 32));
                    }

                    return String.valueOf((char) c);
                })
                .collect(Collectors.joining());

        System.out.println(result);
    }

    private static List<UserDto> fifthTask() {
        List<User> users = Arrays.asList(
                new User("1", "user1@email.com", 10),
                new User("2", "user2@email.com", 15),
                new User("3", "user3@email.com", 20),
                new User("4", "user4@email.com", 25),
                new User("5", "user5@email.com", 30)
        );

        return users
                .stream()
                .filter(user -> user.age > 18)
                .map(UserMapper::mapToDto)
                .toList();
    }

    private static int[] createArrayWithRandomFill(int size, int max){
        Random random = new Random();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max);
        }

        return array;
    }
}
