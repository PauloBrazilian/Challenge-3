package br.com.compassoul.pb.challenge.msproducts.service;

import br.com.compassoul.pb.challenge.msproducts.models.User;
import org.springframework.http.ResponseEntity;



public interface UserService {

    public ResponseEntity<User> userSave(User userProps);

    public ResponseEntity<User> findUserbyId(Integer userId);

    public User userUpdate(Integer userId, User userProps);

}