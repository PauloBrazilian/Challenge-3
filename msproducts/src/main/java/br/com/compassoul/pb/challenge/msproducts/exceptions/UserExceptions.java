package br.com.compassoul.pb.challenge.msproducts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserExceptions extends RuntimeException{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class UserException extends RuntimeException{
        public UserException (String message){
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException (String message){
            super(message);
        }
    }


}