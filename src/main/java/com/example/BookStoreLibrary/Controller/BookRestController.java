package com.example.BookStoreLibrary.Controller;


import com.example.BookStoreLibrary.dto.BookListItemReponse;
import com.example.BookStoreLibrary.dto.BookResponse;
import com.example.BookStoreLibrary.dto.BookSaveRequset;
import com.example.BookStoreLibrary.dto.BookSearchRequest;
import com.example.BookStoreLibrary.service.BookListService;
import com.example.BookStoreLibrary.service.BookSaveService;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1!book")
public class BookRestController {




    private final BookListService bookListService;

    private  final BookSaveService bookSaveService;
    public BookRestController(BookListService bookListService, BookSaveService bookSaveService) {
        this.bookListService = bookListService;
        this.bookSaveService = bookSaveService;
    }


    @PostMapping(name = "/save")

    public ResponseEntity<BookListItemReponse> saveBook(@RequestBody BookSaveRequset request){

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(bookSaveService.saveBook(request));
    }








































}
