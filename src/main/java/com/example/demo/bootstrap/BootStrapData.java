package com.example.demo.bootstrap;

import com.example.demo.domain.Autor;
import com.example.demo.domain.Books;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AutorRepository autorRepository;


    private final BookRepository bookRepository;


    public BootStrapData(AutorRepository autorRepository, BookRepository bookRepository) {
        this.autorRepository = autorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Autor autor = new Autor("кто-то");
        Books books = new Books("какая-то", "12121");
        autor.getBooks().add(books);
        books.getAutors().add(autor);

        autorRepository.save(autor);
        bookRepository.save(books);

        System.out.println(bookRepository.count());
        System.out.println(autorRepository.count());

    }
}
