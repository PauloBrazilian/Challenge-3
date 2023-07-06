package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;


public interface EmailService {

    public EmailModel sendEmail(EmailModel emailModel);

}