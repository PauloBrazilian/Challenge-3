package br.com.compassoul.pb.challenge.msnotification.repository;

import br.com.compassoul.pb.challenge.msnotification.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Integer> {
}
