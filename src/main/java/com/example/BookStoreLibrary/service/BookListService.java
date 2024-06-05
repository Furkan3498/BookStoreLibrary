package com.example.BookStoreLibrary.service;


import com.example.BookStoreLibrary.dto.BookResponse;
import com.example.BookStoreLibrary.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListService {

    private CategoryRepository categoryRepository;

    public BookListService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public List<BookResponse> listBooks(){

    }
}
