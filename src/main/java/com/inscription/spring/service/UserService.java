package com.inscription.spring.service;

import com.inscription.spring.bean.User;
import com.inscription.spring.payload.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAll(User user);

    User getById(Integer id);

    String getRights();

    ResponseEntity<MessageResponse> post(User user);

    ResponseEntity<?> put(Integer id, User user);

    ResponseEntity<MessageResponse> delete(Integer id);
}
