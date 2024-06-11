package com.example.BookStoreLibrary.service;


import com.example.BookStoreLibrary.dto.BookResponse;
import com.example.BookStoreLibrary.dto.BookSearchRequest;
import com.example.BookStoreLibrary.dto.CategoryType;
import com.example.BookStoreLibrary.model.Book;
import com.example.BookStoreLibrary.model.BookStatus;
import com.example.BookStoreLibrary.model.Category;
import com.example.BookStoreLibrary.repository.BookRepository;
import com.example.BookStoreLibrary.repository.CategoryRepository;
import lombok.Builder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class BookListService {

    private CategoryService categoryService;
    private BookRepository bookRepository;

    public BookListService(CategoryService categoryService, BookRepository bookRepository) {
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> listBooks(int size, int page) {

        return bookRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());

    }

    private static BookResponse convertResponse(Book model) {

        return BookResponse.builder()
                .authorName(model.getAuthorName())
                .title(model.getTitle())
                .imageURL(model.getImage().getImageURL())
                .build();
    }


    public List<BookResponse> searchByCategory(CategoryType categoryType) {

        final Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus) {


        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageURL(each.getImage().getImageURL())
                                .build()

                ).collect(Collectors.toList());
    }


    public List<BookResponse> searchBookTitle(String title) {


        return bookRepository.findByTitle(title)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageURL(each.getImage().getImageURL())
                                .build()

                ).collect(Collectors.toList());
    }
}
