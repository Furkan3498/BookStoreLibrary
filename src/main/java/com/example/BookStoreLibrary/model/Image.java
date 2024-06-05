package com.example.BookStoreLibrary.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "images")

public class Image extends BaseEntity{

    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public Image() {

    }
}
