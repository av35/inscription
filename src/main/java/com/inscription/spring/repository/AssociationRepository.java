package com.inscription.spring.repository;

import com.inscription.spring.bean.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association, Integer> {
}
