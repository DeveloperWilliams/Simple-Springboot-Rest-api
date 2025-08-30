package main.java.com.example.bookstore.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer stock;
}
