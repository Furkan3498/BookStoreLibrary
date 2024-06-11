package com.example.BookStoreLibrary.Controller;


import com.amazonaws.services.dynamodbv2.xspec.L;
import com.example.BookStoreLibrary.dto.*;
import com.example.BookStoreLibrary.model.BookStatus;
import com.example.BookStoreLibrary.service.BookListService;
import com.example.BookStoreLibrary.service.BookSaveService;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {




    private final BookListService bookListService;

    private  final BookSaveService bookSaveService;
    public BookRestController(BookListService bookListService, BookSaveService bookSaveService) {
        this.bookListService = bookListService;
        this.bookSaveService = bookSaveService;
    }


    @PostMapping("/save")

    public ResponseEntity<BookListItemReponse> saveBook(@RequestBody BookSaveRequset request){

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(bookSaveService.saveBook(request));
    }


    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam (name = "size") int size,  @RequestParam (name = "page") int page ){
        return  ResponseEntity.ok(bookListService.listBooks(size,page));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType){
        return ResponseEntity.ok(this.bookListService.searchByCategory(categoryType));
    }
    @GetMapping("/list/{status}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable BookStatus bookStatus){
        return ResponseEntity.ok(this.bookListService.searchBookStatus(bookStatus));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable String title){
        return ResponseEntity.ok(this.bookListService.searchBookTitle(title));



    }


}
