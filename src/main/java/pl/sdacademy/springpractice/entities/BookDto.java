package pl.sdacademy.springpractice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDto {

    private Long id;
    //uuid lepszy niz long

    //obiekt warto zwalidowac zaraz po utworzeniu - dodajemy np not null
    @NotNull
    @Length(min=13, max=13, message="za krotki isbn")
//dodajemy message aby bylo wiadomo co zjebane
    // mozna ew pattern - regex
    private String isbn;


    @NotNull
    @Length(min=2, message = "to short")
    private String title;

    @NotNull
    @Length(min=2, message = "to short")
    private String author;

    @NotNull
    @Min(value=1, message = "to short")
   /* @Min(1)*/ //bez message moze tak byc, przy message value=1
    private Integer pages;


}
