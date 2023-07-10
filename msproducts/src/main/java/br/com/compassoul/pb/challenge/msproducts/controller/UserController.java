package br.com.compassoul.pb.challenge.msproducts.controller;

import br.com.compassoul.pb.challenge.msproducts.models.User;
import br.com.compassoul.pb.challenge.msproducts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> userSave(User userProps){
        return userService.userSave(userProps);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> findUserbyId(Integer userId){
        return userService.findUserbyId(userId);
    }

    @PutMapping("/user/{userId}")
    public User userUpdate(Integer userId,User userProps){
        return userService.userUpdate(userId, userProps);
    }
}