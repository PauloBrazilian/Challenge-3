package br.com.compassoul.pb.challenge.msnotification.controller;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailDto);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}