package com.example.BookStoreLibrary.repository;

import com.example.BookStoreLibrary.model.Book;
import com.example.BookStoreLibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Book> {

    Optional<Category> findByName(String name);
}
