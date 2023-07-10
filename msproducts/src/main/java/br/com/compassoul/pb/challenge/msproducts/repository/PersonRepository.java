package br.com.compassoul.pb.challenge.msproducts.repository;

import br.com.compassoul.pb.challenge.msproducts.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
