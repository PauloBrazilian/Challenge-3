package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.exception.EmailException;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.repository.EmailRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public ResponseEntity<EmailModel> sendEmail(EmailModel emailModel) {
        String fromEmail = emailModel.getFromEmail();
        String fromName = emailModel.getFromName();
        String replyTo = emailModel.getReplyTo();
        String subject = emailModel.getSubject();
        String body = emailModel.getBody();

        if (fromEmail == null || fromName == null || replyTo == null || subject == null || body == null) {
            throw new EmailException.BadRequestEmail("Todos os campos devem ser preenchidos");
        } else {
//            EmailDto emaildto = emailRepository.save();
//            return ResponseEntity.ok(emaildto);
            return null;
        }
    }

}
