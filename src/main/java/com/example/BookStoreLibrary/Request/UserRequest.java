package com.example.BookStoreLibrary.Request;

import com.example.BookStoreLibrary.dto.UserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String username;
    private UserRoleDto role;
    private String email;
    private String password;
}
