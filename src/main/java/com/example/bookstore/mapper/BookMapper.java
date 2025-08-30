package main.java.com.example.bookstore.mapper;

import org.mapstruct.*;
import java.util.List;
import com.example.bookstore.entity.Book;
import com.example.bookstore.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto dto);
    List<BookDto> toDtoList(List<Book> books);
}
