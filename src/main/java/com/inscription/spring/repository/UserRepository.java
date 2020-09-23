package com.inscription.spring.repository;

import com.inscription.spring.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
