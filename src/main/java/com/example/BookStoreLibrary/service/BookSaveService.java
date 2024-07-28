package com.example.BookStoreLibrary.service;


import com.example.BookStoreLibrary.dto.BookListItemReponse;
import com.example.BookStoreLibrary.Request.BookSaveRequset;
import com.example.BookStoreLibrary.model.Book;
import com.example.BookStoreLibrary.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor  instead of uses constructor ınjection
public class BookSaveService {


    //@Autowired instead of uses constructor ınjection but that dont work with test


    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    public BookSaveService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Transactional
//transactional çalışması için metodun private değil public olması gerekiyor. Çünkü transactional çalışırken metodu overide ediyor.
//aspectleri kullandığımız yerde metodların private olması gerekiyor
    public BookListItemReponse saveBook(BookSaveRequset saveBookRequest) {
        //      Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());


        Book book = new Book();
        book.setLastPageNumber(saveBookRequest.getLastPageNumber());
        book.setTitle(saveBookRequest.getTitle());
      //  book.setCategory(category);
        book.setBookStatus(saveBookRequest.getBookStatus());
        book.setAuthorName(saveBookRequest.getAuthorName());
        book.setTotalPage(saveBookRequest.getTotalPage());
        book.setPublisher(saveBookRequest.getPublisher());
        final Book fromDb = bookRepository.save(book);
        return BookListItemReponse.builder()
                //       .categoryName(fromDb.getCategory().getName())
                .id(fromDb.getId())
                .bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher())
                .authorName(fromDb.getAuthorName())
                .totalPage(fromDb.getTotalPage())
                .lastPageNumber(fromDb.getLastPageNumber())
                .title(fromDb.getTitle())
                .build();


    }
}




