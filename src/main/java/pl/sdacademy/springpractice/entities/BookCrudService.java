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
        return toBookDto(savedBook);
    }

    public BookDto getBook(Long id) {
       return bookRepository.findById(id) //optional, metoda map
                .map(this::toBookDto) //szukamy po id, jak nie ma dtosa to zwraca wyjatek
                .orElseThrow(()->new SdaException("Book with id " + id + " not four"));

    }

    public BookDto updateBook(Long id,BookDto bookDto) {
       return bookRepository.findById(id)
                .map(book-> { //do osobnej metody bo wielolinijkowa
                    book.setAuthor(bookDto.getAuthor());
                    book.setIsbn(bookDto.getIsbn());
                    book.setPages(bookDto.getPages());
                    book.setTitle(bookDto.getTitle());
                    return toBookDto(bookRepository.save(book)); //zwraca obiekt a my jeszcze musomy przemapowac
                }).orElseThrow(()-> new SdaException("Book with id " + id + " not four"));
               //consumer
               // .ifPresentOrElse(); //co jesli optional jest pusty, tu bylby void
    };


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
        //metoda identpotentna - przy podwojnym wywowalniu lub wiecej dostaniemy ten sam respons
        //ktróre są - get tak, post nie, aktualizacja tak, delete tez

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

    private BookDto toBookDto(Book book) { //w druga stornę
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPages());
        // null);
    };


}
