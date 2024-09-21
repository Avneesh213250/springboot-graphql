package com.graphql.service;


import com.graphql.entity.Auther;
import com.graphql.entity.Book;
import com.graphql.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void saveInitialDataToH2(){

        List<Book>  books = List.of(new Book("Book1", 100, new Auther("Avneesh")),
                new Book("Book2", 200, new Auther( "Lucky")),
                new Book("Book3", 500, new Auther( "Rohit")),
                new Book("Book4", 500, new Auther( "Vishal")));
                books.forEach(book -> book.getAuther().setBook(book));
                bookRepository.saveAll(books);


    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, String name, Integer pageCount){
        Optional<Book> bookOp = bookRepository.findById(id);
        if(bookOp.isPresent()){
            Book book = bookOp.get();
            book.setName(name);
            book.setPageCount(pageCount);
            return bookRepository.save(book);
        }
        throw new RuntimeException("Book does not exist");
    }

    public Optional<Book> findById(Integer id){
        return bookRepository.findById(id);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public String delete(Integer id){
        bookRepository.deleteById(id);
        return "Done";
    }


}
