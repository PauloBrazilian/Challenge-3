package br.com.compassoul.pb.challenge.msproducts.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductExceptions extends RuntimeException{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductException extends RuntimeException{
        public ProductException (String message){
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFoundException extends RuntimeException{
        public ProductNotFoundException (String message){
            super(message);
        }
    }
}