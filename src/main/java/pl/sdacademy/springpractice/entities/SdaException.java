package pl.sdacademy.springpractice.entities;
//w springu tylko unchecked exception, nie piszemy checked
//wykorzystujemy runtime exception
public class SdaException extends RuntimeException {
    public SdaException(String message){
        super(message);
    }

}
