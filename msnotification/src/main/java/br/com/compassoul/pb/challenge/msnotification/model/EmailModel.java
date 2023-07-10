package br.com.compassoul.pb.challenge.msnotification.model;


import br.com.compassoul.pb.challenge.msnotification.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EmailModel")
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emailId;
    private String fromEmail;
    private String fromName;
    private String replyTo;

    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String contentType;

    private StatusEmail statusEmail;


    @Override
    public String toString() {
        return "EmailModel{" +
                "fromEMail='" + fromEmail + '\'' +
                ", fromName='" + fromName + '\'' +
                ", replyTo='" + replyTo + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}