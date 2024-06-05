package com.example.BookStoreLibrary.dto;

import com.example.BookStoreLibrary.model.BookStatus;
import lombok.Data;

import java.io.File;

@Data
public class BookResponse {
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Integer totalPage;
    private Long categoryId;
}
