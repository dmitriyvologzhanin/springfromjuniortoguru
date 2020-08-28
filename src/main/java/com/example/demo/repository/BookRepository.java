package com.example.demo.repository;

import com.example.demo.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
}
