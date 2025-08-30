package main.java.com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // add custom queries 
}
