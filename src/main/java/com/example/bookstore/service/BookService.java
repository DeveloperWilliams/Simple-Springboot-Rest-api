package main.java.com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBookById(Long id);
    List<BookDto> getAllBooks();
    BookDto updateBook(Long id, BookDto bookDto);
    void deleteBook(Long id);
}
