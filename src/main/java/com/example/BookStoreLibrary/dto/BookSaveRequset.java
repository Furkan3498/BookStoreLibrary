package com.example.BookStoreLibrary.dto;

import com.example.BookStoreLibrary.model.BookStatus;
import com.example.BookStoreLibrary.model.Category;
import com.example.BookStoreLibrary.model.Image;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;


@Setter
@Getter
@Builder
public class BookSaveRequset {
    private Long bookId;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Integer totalPage;
    private Long categoryId; //category yerine
}
