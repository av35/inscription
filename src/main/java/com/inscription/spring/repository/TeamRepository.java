package com.inscription.spring.repository;

import com.inscription.spring.bean.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
