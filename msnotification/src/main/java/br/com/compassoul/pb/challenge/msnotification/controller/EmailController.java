package br.com.compassoul.pb.challenge.msnotification.controller;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.service.EmailService;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender emailSender;

    public EmailController(EmailService emailServiceImpl, JavaMailSender emailSender) {
        this.emailService = emailServiceImpl;
        this.emailSender = emailSender;
    }

    @PostMapping("/send")
    public EmailModel sendEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        return emailService.sendEmail(emailDto);
    }

}