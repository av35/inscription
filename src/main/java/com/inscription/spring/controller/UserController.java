package com.inscription.spring.controller;

import com.inscription.spring.bean.User;
import com.inscription.spring.payload.MessageResponse;
import com.inscription.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/all")
    public List<User> getAll(@RequestBody User user){
        return userService.getAll(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @GetMapping("/right")
    public String getRights() {
        return userService.getRights();
    }

    @PostMapping
    public ResponseEntity<MessageResponse> post(@RequestBody User user) {
        return userService.post(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable("id") int id, @RequestBody User user) {
        return userService.put(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

}
