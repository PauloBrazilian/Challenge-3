package br.com.compassoul.pb.challenge.msproducts.controller;

import br.com.compassoul.pb.challenge.msproducts.models.Person;
import br.com.compassoul.pb.challenge.msproducts.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class PersonController {

    private PersonServiceImpl personServiceImpl;


    @Autowired
    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping("/persons")
    public Person personSave(@RequestBody Person personProps){
        return personServiceImpl.personSave(personProps);
    }

    @GetMapping("/persons/{personId}")
    public ResponseEntity<Person> findPersonbyId(@PathVariable Integer personId){
        return personServiceImpl.findPersonbyId(personId);
    }

    @PutMapping("/persons/{personId}")
    public Person personUpdate(@PathVariable Integer personId,@RequestBody Person personProps){
        return personServiceImpl.personUpdate(personId, personProps);
    }
}