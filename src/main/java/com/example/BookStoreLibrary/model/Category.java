package com.example.BookStoreLibrary.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
public class Category extends BaseEntity {


    private String name;


    @OneToMany(mappedBy = "category")
    @JsonIgnore  //if we add new category that ignore new book
    private List<Book> books;


}
