package com.example.BookStoreLibrary.repository;

import com.example.BookStoreLibrary.model.Book;
import com.example.BookStoreLibrary.model.BookStatus;
import com.example.BookStoreLibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>,JpaSpecificationExecutor<Book>{

    List<Book> findByBookStatus(BookStatus bookStatus);
}
