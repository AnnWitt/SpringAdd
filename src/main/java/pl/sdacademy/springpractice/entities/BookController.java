package pl.sdacademy.springpractice.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookCrudService bookCrudService;

    @GetMapping("/{id}")
    public BookDto findBook(@PathVariable (name="id") Long id) { //path variable, musi byc jeżelui tu inna nazwa
        //jeżeli ta sama to nie jest potrzebne
        return bookCrudService.getBook(id);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //jak ok to 201 // bez tego zrobi 200 (default
    public BookDto createBook(@RequestBody BookDto bookdto){
        return bookCrudService.createBook(bookdto);
        // "body ma trafić do tego argumentu, przekazanie zmiennej
        // żadanie http, wez mappery i na podstawie contenttype, wez maper i przekonwertuj na obiekt
        //response powinien byc 201
    }

}
