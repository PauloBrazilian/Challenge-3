package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.enums.StatusEmail;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.repository.EmailRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailServiceImpl(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    public EmailModel sendEmail(EmailModel emailModel) {

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getFromEmail());
            message.setTo(emailModel.getFromName());
            message.setReplyTo(emailModel.getReplyTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getBody());

            emailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.SEND);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }

        return emailRepository.save(emailModel);
    }




}
