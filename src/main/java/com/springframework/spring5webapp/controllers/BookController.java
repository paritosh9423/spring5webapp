package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

private BookRepository bookrepo;

    public BookController(BookRepository bookrepo) {
        this.bookrepo = bookrepo;
    }
    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookrepo.findAll());//it will find all list of books from DB and associate with "books" and tell view to rendr this in appropriate manner
        return "books";
    }
}
