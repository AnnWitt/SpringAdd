package pl.sdacademy.springpractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@RequiredArgsConstructor //-Tworzy konstruktory dla wszystkich klas
public class OnStartup implements CommandLineRunner {


    private final SomeClassA someClassA;
    private final SomeClassB someClassB;
    private final SomeClassC someClassC;
    private final InterfaceA classB; //wskazanie którą implementacje interfejsu bierzemy
    private final List<InterfaceA> interfaces; //mozna wstrzyknac cala liste implementacji


    public OnStartup(SomeClassA someClassA, SomeClassB someClassB, SomeClassC someClassC,
                     @Qualifier("classB2") InterfaceA classB, List<InterfaceA> interfaces) { //-bez AllArgs, wskazujemy pole klasy
        this.someClassA = someClassA;
        this.someClassB = someClassB;
        this.someClassC = someClassC;
        this.classB = classB;
        this.interfaces = interfaces;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        classB.hi(); //wskazanie którą implementacje interfejsu bierzemy
    }
}
