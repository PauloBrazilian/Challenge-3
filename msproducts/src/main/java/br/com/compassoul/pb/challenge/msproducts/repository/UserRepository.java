package br.com.compassoul.pb.challenge.msproducts.repository;

import br.com.compassoul.pb.challenge.msproducts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
