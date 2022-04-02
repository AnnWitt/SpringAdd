package pl.sdacademy.springpractice;

//rejestracja wielu beanów do kontekctu
//wstrzykiwaie - autowired nad konsturktorem i nad polem ale juz nie uzywamy
//najlepiej korzystac z konstruktora (dla kodu produkcyjnego)

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeClassConfiguration {

    @Bean
    public SomeClassA comeClassA() {
        return new SomeClassA();
    }

    @Bean
    public SomeClassB comeClassB() {
        return new SomeClassB();
    }

    @Bean
    public SomeClassC comeClassC() {
        return new SomeClassC();
    }
}
