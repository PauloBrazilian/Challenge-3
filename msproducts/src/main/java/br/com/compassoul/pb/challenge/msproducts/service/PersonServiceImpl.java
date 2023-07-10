package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.exceptions.UserExceptions;
import br.com.compassoul.pb.challenge.msproducts.models.Person;
import br.com.compassoul.pb.challenge.msproducts.models.Role;
import br.com.compassoul.pb.challenge.msproducts.repository.PersonRepository;
import br.com.compassoul.pb.challenge.msproducts.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Person personSave(Person personProps) {
        String firstName = personProps.getFirstName();
        String lastName = personProps.getLastName();
        String email = personProps.getEmail();
        String password = personProps.getPassword();
        List<Role> roles = personProps.getRoles();

        if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                email == null || email.isEmpty() ||
                password == null || password.isEmpty() ||
                roles == null || roles.isEmpty()) {
            throw new UserExceptions.UserException("Todos os campos devem ser preenchidos");
        } else {
            Person savedPerson = new Person();
            savedPerson.setFirstName(firstName);
            savedPerson.setLastName(lastName);
            savedPerson.setEmail(email);
            savedPerson.setPassword(password);
            savedPerson.setRoles(roles);

            savedPerson.setRoles(roleRepository.saveAll(savedPerson.getRoles()));
            return personRepository.save(savedPerson);
        }
    }

    @Override
    public ResponseEntity<Person> findPersonbyId(Integer personId) {
        Optional<Person> userOptional = personRepository.findById(personId);

        if (userOptional.isPresent()){
            Person person = userOptional.get();
            return ResponseEntity.ok(person);
        }else {
            throw new UserExceptions.UserNotFoundException("Person " + personId + " invalido");
        }
    }

    @Override
    public Person personUpdate(Integer personId, Person personProps) {
        Optional<Person> userOptional = personRepository.findById(personId);

        if (userOptional.isPresent()) {
            Person person = userOptional.get();

            String newFirstName = personProps.getFirstName();
            String newLastName = personProps.getLastName();
            String newEmail = personProps.getEmail();
            String newPassword = personProps.getPassword();
            List<Role> newRole = personProps.getRoles();

            if (newFirstName == null || newLastName == null || newEmail == null || newPassword == null || newRole == null) {
                throw new UserExceptions.UserException("Todos os campos devem ser preenchidos");
            }

            person.setFirstName(newFirstName);
            person.setLastName(newLastName);
            person.setEmail(newEmail);
            person.setPassword(newPassword);
            person.setRoles(newRole);

            return personRepository.save(person);
        } else {
            throw new UserExceptions.UserException("Usuário não encontrado");
        }
    }

}