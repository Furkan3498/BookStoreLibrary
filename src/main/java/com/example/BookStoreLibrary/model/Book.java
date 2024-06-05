package com.example.BookStoreLibrary.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class Book extends BaseEntity{


    private String title;
    private String authorName;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;


    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    private Long userId;
}
