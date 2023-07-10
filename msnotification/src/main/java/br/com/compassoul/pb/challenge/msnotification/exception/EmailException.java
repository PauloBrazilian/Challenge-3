package br.com.compassoul.pb.challenge.msnotification.exception;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailException extends RuntimeException{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestEmail extends RuntimeException{
        public BadRequestEmail(String message){
            super(message);
        }
    }


}