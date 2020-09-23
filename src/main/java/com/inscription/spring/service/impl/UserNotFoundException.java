package com.inscription.spring.service.impl;

class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer id) {
        super("Could not find user " + id);
    }
}
