package com.springframework.spring5webapp.controllers;

import com.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
private AuthorRepository authrepo;

    public AuthorController(AuthorRepository authrepo) {
        this.authrepo = authrepo;
    }
    @RequestMapping("authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authrepo.findAll());
        return "authors";
    }

}