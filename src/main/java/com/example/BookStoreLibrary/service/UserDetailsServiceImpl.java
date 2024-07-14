package com.example.BookStoreLibrary.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.BookStoreLibrary.model.User;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username);
        var roles = Stream.of(user.getUserRole())
                .map(role-> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());


        return new org.springframework.security.core.userdetails.User(user.getUsernane(),user.getPassword(), roles);
    }
}
