package pl.sdacademy.springpractice;

import org.springframework.boot.CommandLineRunner;

public class OnStartup implements CommandLineRunner {

    @Override
public void run(String... args) throws Exception {
        System.out.println("Hello World!");
    }
}
