package com.example.BookStoreLibrary.dto;

import com.example.BookStoreLibrary.model.BookStatus;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Integer totalPage;
    private Long categoryId;
    private String imageURL;
}
