package com.example.demo.bootstrap;

import com.example.demo.domain.Autor;
import com.example.demo.domain.Books;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AutorRepository autorRepository;
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AutorRepository autorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.autorRepository = autorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Title1", "SPB");
        publisherRepository.save(publisher);

        Autor autor = new Autor("кто-то");
        Books books = new Books("какая-то", "12121");
        autor.getBooks().add(books);
        books.getAutors().add(autor);
        books.setPublisher(publisher);
        publisher.getBooks().add(books);

        autorRepository.save(autor);
        bookRepository.save(books);
        publisherRepository.save(publisher);

        System.out.println(bookRepository.count());
        System.out.println(autorRepository.count());
        System.out.println(publisherRepository.count());

    }
}
