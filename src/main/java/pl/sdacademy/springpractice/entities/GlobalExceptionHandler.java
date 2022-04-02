package pl.sdacademy.springpractice.entities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//klasa odpowiedzialna za obsługę wyjątków

@RestControllerAdvice //controles advice + response body, klasa odpowiedzialna za obsługe wyjatków
//moze byc zesyaw metod okreslajaca jakie wyjatki obsluzyc. Do tego ExceptionHandler
@Slf4j //wrzuca do klasy pole o nazwie log.warn("exceprion occured",exception)
public class GlobalExceptionHandler {

    @ExceptionHandler(SdaException.class) //jeden argument, wyjatek ktory zostaje wyrzucony
    @ResponseStatus(HttpStatus.NOT_FOUND)//mozemy traktowac jako kolejny endpoint

    //public void handle(SdaException exception) {

    public Error handle(SdaException exception) { //zamiast void
        log.warn("Excepion occured", exception);

        return new Error(exception.getMessage());
    }

    //klasa przedstawia obiekt błędu - klasa Error

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error handle(MethodArgumentNotValidException exception){
        List<String> details = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter((Objects::nonNull))
                .toList();
        // .collect(Collectors.toUnmodifiableList());
        return new Error("input invalid mthd not valid",details);
    }

    //generyczny na wszystkie inne wyjatki
        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public Error handle (Exception exception){
            return new Error("Unexpected, zwroci 500");
        }
    }




