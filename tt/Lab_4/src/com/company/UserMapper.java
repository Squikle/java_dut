package com.company;

public class UserMapper {
    public static User mapToUser(UserDto userDto){
        User user = new User();
        user.name = userDto.name;
        user.age = userDto.age;
        user.email = userDto.email;
        return user;
    }

    public static UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.name = user.name;
        userDto.age = user.age;
        userDto.email = user.email;
        return userDto;
    }
}