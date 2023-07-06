package br.com.compassoul.pb.challenge.msnotification.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailDto {

    @NotBlank @NotNull
    private String fromEmail;

    @NotBlank @NotNull @Email
    private String fromName;

    @NotBlank @NotNull @Email
    private String replyTo;

    @NotBlank @NotNull
    private String subject;

    @NotBlank @NotNull
    private String body;

}