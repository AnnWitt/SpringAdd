package pl.sdacademy.springpractice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {

    private Long id;
    //uuid lepszy niz long
    private String isbn;
    private String title;
    private String author;
    private String pages;


}