package pl.sdacademy.springpractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity (name="books")
//@Table(name="books")   //zmienia tez nazwe encji w hql
//Entity czy Table, roznica:
//pod spodem mamy hibernate
//Table hql jezyk zapytan z poziomu javy
//+
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id //mozna jakis domyslny
    @GeneratedValue //wskazujemy okreslon (strategię - domyslnie auto to sam wybiera na podstawie bazy danych, zwykle H2
    // - table/identity/sequence
    //ctrl + p //domyslna wartosc, podgląd
    private Long id;
    //uuid lepszy niz long
    private String isbn;
    private String title;
    private String author;
    private String pages;
    //jakby tu był enume to @enum erated dodac

@CreationTimestamp
private LocalDateTime creationDate;

    public Book(Long id, String isbn, String title, String author, String pages) {
    }

//tu powinien byc ten konstruktor do creationDAte z BookCrudService

}
