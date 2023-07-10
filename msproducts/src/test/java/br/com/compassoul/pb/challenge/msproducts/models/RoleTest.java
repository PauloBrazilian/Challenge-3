package br.com.compassoul.pb.challenge.msproducts.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(value = MockitoExtension.class)
class RoleTest {

    @Test
    void testToString() {
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("Admin");

        String roleTest = role.toString();

        assertEquals("Role{" +
                "roleId=" + 1L +
                ", roleName='Admin'" +
                ", persons=" + null +
                '}', roleTest);
    }

    @Test
    void getRoleId() {
        Role role = new Role();
        Integer roleId = 1;
        role.setRoleId(roleId);
        assertEquals(1, role.getRoleId());
    }

    @Test
    void getRoleName() {
        Role role = new Role();
        String roleName = role.getRoleName();
        assertNull(roleName);
    }

    @Test
    void getPersons() {
        Role role = new Role();
        List<Person> personList = role.getPersons();
        assertNull(personList);
    }

    @Test
    void setRoleId() {
        Role role = new Role();
        Integer roleId = 1;
        role.setRoleId(roleId);
        assertEquals(1, role.getRoleId());
    }

    @Test
    void setRoleName() {
        Role role = new Role();
        String roleName = "Paulo";
        role.setRoleName(roleName);
        assertEquals("Paulo", role.getRoleName());
    }

    @Test
    void setPersons() {
        Role role = new Role();
        List<Person> personList = role.getPersons();
        role.setPersons(personList);
        assertEquals(personList, role.getPersons());
    }
}