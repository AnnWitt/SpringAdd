package pl.sdacademy.springpractice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary //domyslna implementacja intej. ktora zostanie wstrzyknieta. mozna np Qualifier darowac
        // mozna primary albo wskazac konkretna
@Component
public class ClassC implements InterfaceA {

    @Override
    public void hi() {

    }
}
