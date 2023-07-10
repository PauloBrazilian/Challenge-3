package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.models.Person;
import org.springframework.http.ResponseEntity;



public interface PersonService {

    public Person personSave(Person personProps);

    public ResponseEntity<Person> findPersonbyId(Integer personId);

    public Person personUpdate(Integer personId, Person personProps);

}