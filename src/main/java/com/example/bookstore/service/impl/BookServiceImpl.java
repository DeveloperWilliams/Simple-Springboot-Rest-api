package main.java.com.example.bookstore.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import com.example.bookstore.service.BookService;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.dto.BookDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book entity = mapper.toEntity(bookDto);
        Book saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = repository.findById(id)
           .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        return mapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book existing = repository.findById(id)
           .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        existing.setTitle(bookDto.getTitle());
        existing.setAuthor(bookDto.getAuthor());
        existing.setIsbn(bookDto.getIsbn());
        existing.setPrice(bookDto.getPrice());
        existing.setStock(bookDto.getStock());
        Book updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteBook(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        repository.deleteById(id);
    }
}
