package com.company;

public class UserMapper {
    public static UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.email = user.email;
        userDto.age = user.age;
        userDto.name = user.name;

        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        return new User(userDto.name, userDto.email, userDto.age);
    }
}