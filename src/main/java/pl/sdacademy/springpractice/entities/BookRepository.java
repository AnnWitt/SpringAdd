package pl.sdacademy.springpractice.entities;

import org.springframework.data.jpa.repository.JpaRepository;


//@repository - zbedne
public interface BookRepository  extends JpaRepository<Book,Long> { //generyczny podajemy typ encji i ident

    //zdefiniowac zapytanie nazwą metody, adnotacjaQuery


}
