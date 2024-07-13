package com.example.BookStoreLibrary.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_id")
@Data
public class User extends BaseEntity{



    @Column(unique = true)
    private String usernane;


    private String password;


    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    private String eMail;
}
