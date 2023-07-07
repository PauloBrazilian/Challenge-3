package br.com.compassoul.pb.challenge.msnotification.service;

import br.com.compassoul.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import br.com.compassoul.pb.challenge.msnotification.repository.EmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmailServiceTest {

//    @Mock
//    private EmailRepository emailRepository;
//
//    @Mock
//    private JavaMailSender javaMailSender;
//
//    @InjectMocks
//    private EmailService emailService;
//
//
//    private static final String fromEmail = "estudantepaulocruz@gmail.com";
//    private static final String fromName = "Paulo";
//    private static final String replyTo = "Paulo.rdndc@gmail.com";
//    private static final String subject = "Foi";
//    private static final String body = "Pode ficar feliz agora";
//
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void sendEmail() {
//        SimpleMailMessage sentMessage = new SimpleMailMessage();
//        doAnswer(invocation -> {
//            sentMessage.copyTo(invocation.getArgument(0));
//            return null;
//        }).when(javaMailSender).send(any(SimpleMailMessage.class));
//
//        EmailModel expectedResponse = new EmailModel();
//        expectedResponse.setFromEmail(fromEmail);
//        expectedResponse.setFromName(fromName);
//        expectedResponse.setReplyTo(replyTo);
//        expectedResponse.setSubject(subject);
//        expectedResponse.setBody(body);
//
//        when(emailRepository.save(any(EmailModel.class))).thenReturn(expectedResponse);
//
//        EmailDto emailDto = new EmailDto();
//        emailDto.setFromEmail(fromEmail);
//        emailDto.setFromName(fromName);
//        emailDto.setReplyTo(replyTo);
//        emailDto.setSubject(subject);
//        emailDto.setBody(body);
//
//        EmailModel response = emailService.sendEmail(new EmailDto());
//
//        assertNotNull(response);
//        assertEquals(EmailModel.class, response.getClass());
//        assertEquals(fromEmail, response.getFromEmail());
//        assertEquals(fromName, response.getFromName());
//        assertEquals(replyTo, response.getReplyTo());
//        assertEquals(subject, response.getSubject());
//        assertEquals(body, response.getBody());
//
//        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
//        verify(emailRepository, times(1)).save(any(EmailModel.class));
//    }

}