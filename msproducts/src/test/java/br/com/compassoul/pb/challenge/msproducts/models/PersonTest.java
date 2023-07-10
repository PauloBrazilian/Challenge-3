package br.com.compassoul.pb.challenge.msproducts.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @Test
    void testToString() {
        Person person = new Person();
        person.setPersonId(1);
        person.setFirstName("Paulo");
        person.setLastName("Paulo");
        person.setEmail("Paulo");
        person.setPassword("Paulo");
        person.setRoles(new ArrayList<>());

        String personTest = person.toString();

        assertEquals("Person{" +
                "personId=" + null +
                ", firstName='" + null + '\'' +
                ", lastName='" + null + '\'' +
                ", email='" + null + '\'' +
                ", password='" + null + '\'' +
                ", roles=" + null +
                '}', personTest);
    }

    @Test
    void getPersonId() {
        Person person = new Person();
        Integer personId = 1;
        person.setPersonId(personId);;
        assertEquals(1, person.getPersonId());
    }

    @Test
    void getFirstName() {
        Person person = new Person();
        String personName = person.getFirstName();
        assertNull(personName);
    }

    @Test
    void getLastName() {
        Person person = new Person();
        String last = person.getLastName();
        assertNull(last);
    }

    @Test
    void getEmail() {
        Person person = new Person();
        String email = person.getEmail();
        assertNull(email);
    }

    @Test
    void getPassword() {
        Person person = new Person();
        String password = person.getPassword();
        assertNull(password);
    }

    @Test
    void getRoles() {
        Person person = new Person();
        List<Role> rolesList = person.getRoles();
        assertNull(rolesList);
    }

    @Test
    void setPersonId() {
        Person person = new Person();
        Integer personId = 1;
        person.setPersonId(personId);
        assertEquals(1, person.getPersonId());
    }

    @Test
    void setFirstName() {
        Person person = new Person();
        String first = "Paulo";
        person.setFirstName(first);
        assertEquals("Paulo", person.getFirstName());
    }

    @Test
    void setLastName() {
        Person person = new Person();
        String last = "Paulo";
        person.setLastName(last);
        assertEquals("Paulo", person.getLastName());
    }

    @Test
    void setEmail() {
        Person person = new Person();
        String email = "Paulo";
        person.setEmail(email);
        assertEquals("Paulo", person.getEmail());
    }

    @Test
    void setPassword() {
        Person person = new Person();
        String password = "Paulo";
        person.setPassword(password);
        assertEquals("Paulo", person.getPassword());
    }

    @Test
    void setRoles() {
        Person person = new Person();
        List<Role> rolesList = person.getRoles();
        person.setRoles(rolesList);
        assertEquals(rolesList, person.getRoles());
    }
}