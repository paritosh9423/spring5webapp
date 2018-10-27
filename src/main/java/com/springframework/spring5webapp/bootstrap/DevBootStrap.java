package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repository.AuthorRepository;
import com.springframework.spring5webapp.repository.BookRepository;
import com.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRepo;
    private BookRepository bookRepo;
    private PublisherRepository publisherRepo;

    public DevBootStrap(AuthorRepository authRepo, BookRepository bookRepo,PublisherRepository publisherRepo) {
        this.authRepo = authRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
    Author chetan = new Author("Chetan","Bhagat");
//    Book threeMistakesofMyLife  = new Book("Three Mistakes of my Life","007","Pearson");

//
//    authRepo.save(chetan);
//    bookRepo.save(threeMistakesofMyLife);
        Publisher publisher = new Publisher("Pearson","WhiteHouse,USA") ;
        Book threeMistakesofMyLife = new Book("Three Mistakes of my Life","007",publisher);
        chetan.getBooks().add(threeMistakesofMyLife);

        authRepo.save(chetan);
        publisherRepo.save(publisher);
        bookRepo.save(threeMistakesofMyLife);





    }

}
