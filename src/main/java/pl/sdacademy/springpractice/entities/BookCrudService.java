package pl.sdacademy.springpractice.entities;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //stereotypy
@Transactional //tak jakby byla przed kazda publiczna metoda w klasie
@RequiredArgsConstructor
public class BookCrudService {

    private final BookRepository bookRepository;

    public BookDto createBook(BookDto bookDto) {
        //bookRepository.save(bookDto) //warstwa webowa, musimy zmapować na
        //np statyczne metody w warstwie modelowej lub serwisowej (mappery)
       Book savedBook= bookRepository.save(toBook(bookDto)); //save zwraca zapisana ksiazke

        return null;
    }

    public BookDto getBook(Long id) {
        return null;
    }

    public BookDto update(BookDto bookDto) {
        return null;
    }


    public BookDto deleteBook(Long id) {
        return null;
    }

    //mapper
    private Book toBook(BookDto bookDto) {  //webowej na bazodanowa
        return new Book(
                bookDto.getId(),
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPages());
                // null);
    };

    ; //dodac konstruktor bez tego pola bo ono idzie x hibernate

    private BookDto toBook(Book book) { //w druga stornę
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPages());
        // null);
    };


}
