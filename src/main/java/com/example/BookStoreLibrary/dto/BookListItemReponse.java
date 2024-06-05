package com.example.BookStoreLibrary.dto;


import com.example.BookStoreLibrary.model.BookStatus;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
public class BookListItemReponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Integer totalPage;
    private String categoryName; //category yerine
}
