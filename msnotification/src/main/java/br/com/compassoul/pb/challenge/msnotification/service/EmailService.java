package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailService {

    public ResponseEntity<EmailModel> sendEmail(EmailModel emailModel);

}