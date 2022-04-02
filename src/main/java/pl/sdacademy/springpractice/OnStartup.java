package pl.sdacademy.springpractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sdacademy.springpractice.entities.Book;
import pl.sdacademy.springpractice.entities.BookRepository;

import java.util.List;

@Profile("local1") //dziala tylko dla local1 ale jak sie go usunie to nic sie nie wyswietli bp
//tego beana nie ma w kontekscie. Kod dokladany per profile Profile("local12")
@Component
//@RequiredArgsConstructor //-Tworzy konstruktory dla wszystkich klas
public class OnStartup implements CommandLineRunner {

@Value("${variablea}") //wstrzykniecie dowolnej wartosci z apploc properties
//[po zmianie profilu img 5 zaladuje sie v2 zamiast v1
private String variableAValue;

    @Value("${variableb}")
    private String variableBValue;

    private final SomeClassA someClassA;
    private final SomeClassB someClassB;
    private final SomeClassC someClassC;
    private final InterfaceA classB; //wskazanie którą implementacje interfejsu bierzemy
    private final List<InterfaceA> interfaces; //mozna wstrzyknac cala liste implementacji
    private final BookRepository bookRepository;


    public OnStartup(SomeClassA someClassA, SomeClassB someClassB, SomeClassC someClassC,
                     @Qualifier("classB2") InterfaceA classB, List<InterfaceA> interfaces, BookRepository bookRepository) { //-bez AllArgs, wskazujemy pole klasy
        this.someClassA = someClassA;
        this.someClassB = someClassB;
        this.someClassC = someClassC;
        this.classB = classB;
        this.interfaces = interfaces;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        System.out.println(variableAValue + variableBValue); //v1 ze stringa

   /*     Hello World!
                v2b1
                profile
                b1 jest tylko w application ogolnym a nioe ma w local1. Jeżeli nie ma w local1 to szuka w glownym
        hi*/


        classB.hi(); //wskazanie którą implementacje interfejsu bierzemy
        bookRepository.save(new Book(null,
                "1234","jak pisac w strignu",
                "Andrzej",5,null));

    }
}
