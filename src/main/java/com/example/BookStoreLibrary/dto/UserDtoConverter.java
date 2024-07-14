package com.example.BookStoreLibrary.dto;
import com.example.BookStoreLibrary.model.User;
import com.example.BookStoreLibrary.model.UserRole;
import org.springframework.stereotype.Component;


@Component
public class UserDtoConverter {

    public UserDto convert(User user){

        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsernane());
        userDto.setEmail(user.getEMail());
        userDto.setRole(UserRoleDto.valueOf(user.getUserRole().name()));

        return userDto;

    }


}
