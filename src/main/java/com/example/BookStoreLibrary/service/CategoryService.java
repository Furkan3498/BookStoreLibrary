package com.example.BookStoreLibrary.service;


import com.example.BookStoreLibrary.dto.CategoryType;
import com.example.BookStoreLibrary.model.Category;
import com.example.BookStoreLibrary.repository.CategoryRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }


    public  Category findByName (String value){

        return categoryRepository.findByName(value).orElseThrow(RuntimeException::new);

    }
}
