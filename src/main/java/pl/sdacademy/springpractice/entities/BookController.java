package pl.sdacademy.springpractice.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public BookDto createBook(@Valid @RequestBody BookDto bookdto){ //Valid przy tworzeniu sprawdz wzgledem adnotacji validacynych
        return bookCrudService.createBook(bookdto);
        // "body ma trafić do tego argumentu, przekazanie zmiennej
        // żadanie http, wez mappery i na podstawie contenttype, wez maper i przekonwertuj na obiekt
        //response powinien byc 201
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @PathVariable Long id, @RequestBody BookDto bookDto) {
        bookCrudService.updateBook(id, bookDto);
    }


    //valid przy post i put

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookCrudService.deleteBook(id);
    }

}
