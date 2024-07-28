package com.example.BookStoreLibrary.Request;

import com.example.BookStoreLibrary.model.BookStatus;
import com.example.BookStoreLibrary.model.Category;
import com.example.BookStoreLibrary.model.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;


@Setter
@Getter
@Builder
public class BookSaveRequset {


    //@NotBlank @NotNull  @NotEmpty

    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;

    private File image;
   // @NotNull
    //private Long categoryId; //category yerine
    @NotNull
    private Integer totalPage;

}
