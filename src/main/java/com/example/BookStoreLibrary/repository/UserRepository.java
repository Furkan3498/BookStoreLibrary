package com.example.BookStoreLibrary.repository;

import com.example.BookStoreLibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
