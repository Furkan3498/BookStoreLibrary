package com.example.BookStoreLibrary.dto;

public enum CategoryType {

    RESEARCH_HISTORY("ARASTIRMACI- Tarih"),
    SCIENCE("Bilim"),
    COMIC("Çizgi Roman"),
    CHILD_AND_YOUTH("Çocuk ve Gençlik"),
    FOREIGN_LANGUAGES("Foreing Languages"),
    HOMOR("MİZAH");

    private final String value;

    CategoryType(String value) {
        this.value = value;
    }
}
