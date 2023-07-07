package br.com.compassoul.pb.challenge.msnotification.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailDto {

    @NotBlank
    private String fromEmail;

    @Email
    private String fromName;

    @Email
    private String replyTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    @NotBlank
    private String contentType;

}