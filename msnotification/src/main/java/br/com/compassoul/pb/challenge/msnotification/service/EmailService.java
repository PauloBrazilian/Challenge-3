package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.enums.StatusEmail;
import br.com.compassoul.pb.challenge.msnotification.exception.EmailException;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.repository.EmailRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    public EmailModel sendEmail(EmailDto emailDto){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(emailDto.getFromEmail());
            messageHelper.addTo(emailDto.getFromName());
            messageHelper.setReplyTo(emailDto.getReplyTo());
            messageHelper.setSubject(emailDto.getSubject());
            messageHelper.setText(emailDto.getBody());
            messageHelper.setCc(emailDto.getContentType());

        };

        if (messagePreparator == null){
            throw new EmailException.BadRequestEmail("Todos dos campos devem ser preenchidos ");
        }else{
            emailSender.send(messagePreparator);
        }

           EmailModel emailModel = new EmailModel();
        try{

            emailModel.setFromEmail(emailModel.getFromEmail());
            emailModel.setFromName(emailModel.getFromName());
            emailModel.setReplyTo(emailModel.getReplyTo());
            emailModel.setSubject(emailModel.getSubject());
            emailModel.setBody(emailModel.getBody());
            emailModel.setContentType(emailModel.getContentType());


            emailModel.setStatusEmail(StatusEmail.SEND);
        }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }

        return emailRepository.save(emailModel);
}

}