package com.graphql.controller;


import com.graphql.entity.Auther;
import com.graphql.entity.Book;
import com.graphql.entity.BookInput;
import com.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookGraphqlController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @QueryMapping
    public Optional<Book> findById(@Argument Integer id){
        return bookService.findById(id);
    }

    @MutationMapping
    public Book save(@Argument BookInput bookInput){
        Book book =new Book(bookInput.getName(), bookInput.getPageCount(), new Auther(bookInput.getAutherInput().getName()));

        return bookService.saveBook(book);
    }

    @MutationMapping
    public Book update(@Argument Integer id, @Argument String name, @Argument Integer pageCount){
        return bookService.updateBook(id, name, pageCount);
    }

    @MutationMapping
    public String delete(@Argument Integer id){
        return bookService.delete(id);
    }
}
