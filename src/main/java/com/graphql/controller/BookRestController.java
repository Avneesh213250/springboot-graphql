package com.graphql.controller;


import com.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.of(Optional.ofNullable(bookService.findAll()));
    }
}
