package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.exceptions.UserExceptions;
import br.com.compassoul.pb.challenge.msproducts.models.Role;
import br.com.compassoul.pb.challenge.msproducts.models.User;
import br.com.compassoul.pb.challenge.msproducts.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<User> userSave(User userProps) {
        String firstName = userProps.getFirstName();
        String lastName = userProps.getLastName();
        String email = userProps.getEmail();
        String password = userProps.getPassword();
        Role role = userProps.getRole();

        if ( firstName == null || lastName == null ||  email == null || password == null || role == null){
            throw new UserExceptions.UserException("Todos os campos devem ser completados");
        } else {
            User savedUser = userRepository.save(userProps);
            return ResponseEntity.ok(savedUser);
        }
    }

    @Override
    public ResponseEntity<User> findUserbyId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        }else {
            throw new UserExceptions.UserNotFoundException("User " + userId + " invalido");
        }
    }

    @Override
    public User userUpdate(Integer userId, User userProps) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            String newFirstName = userProps.getFirstName();
            String newLastName = userProps.getLastName();
            String newEmail = userProps.getEmail();
            String newPassword = userProps.getPassword();
            Role newRole = userProps.getRole();

            if (newFirstName == null || newLastName == null || newEmail == null || newPassword == null || newRole == null) {
                throw new UserExceptions.UserException("Todos os campos devem ser preenchidos");
            }

            user.setFirstName(newFirstName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            user.setRole(newRole);

            return userRepository.save(user);
        } else {
            throw new UserExceptions.UserException("Usuário não encontrado");
        }
    }

}