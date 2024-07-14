package com.example.BookStoreLibrary.service;


import com.amazonaws.services.dynamodbv2.xspec.S;
import com.example.BookStoreLibrary.Exceptions.GenericException;
import com.example.BookStoreLibrary.Exceptions.UserNameNotFoundException;
import com.example.BookStoreLibrary.dto.UserDto;
import com.example.BookStoreLibrary.dto.UserDtoConverter;
import com.example.BookStoreLibrary.dto.UserRequest;
import com.example.BookStoreLibrary.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.BookStoreLibrary.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDtoConverter = userDtoConverter;
    }

    public UserDto createUser(UserRequest userRequest) {

        User user = new User();
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        userRepository.save(user);
        return userDtoConverter.convert(user);


    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UserNameNotFoundException("User details couldn't be found by following id : " + username));
    }

}
