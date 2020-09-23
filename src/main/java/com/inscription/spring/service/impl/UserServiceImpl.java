package com.inscription.spring.service.impl;

import com.inscription.spring.bean.User;
import com.inscription.spring.bean.enums.RightEnum;
import com.inscription.spring.payload.MessageResponse;
import com.inscription.spring.repository.UserRepository;
import com.inscription.spring.service.UserService;
import com.inscription.spring.specification.UserSpecification;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository repository;

    @PersistenceContext
    private final EntityManager em;

    public UserServiceImpl(UserRepository repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    @Override
    public List<User> getAll(User user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<javax.persistence.criteria.Predicate> restrictions = new ArrayList<>();

        query.select(root);

        if(user != null) {
            if(user.getFirstName() != null)
                restrictions.add(UserSpecification.isFirstName(user, cb, root));
            if(user.getLastName() != null)
                restrictions.add(UserSpecification.isLastName(user, cb, root));
            if(user.getBirthDate() != null)
                restrictions.add(UserSpecification.isBirthDate(user, cb, root));
            if(user.getGender() != null)
                restrictions.add(UserSpecification.isGender(user, cb, root));
            if(user.getPostalCode() != null)
                restrictions.add(UserSpecification.isPostalCode(user, cb, root));
            if(user.getCity() != null)
                restrictions.add(UserSpecification.isCity(user, cb, root));
            if(user.getCountry() != null)
                restrictions.add(UserSpecification.isCountry(user, cb, root));
            if(user.getPhoneNumber() != null)
                restrictions.add(UserSpecification.isPhoneNumber(user, cb, root));
            if(user.getAvailability() != null)
                restrictions.add(UserSpecification.isAvailability(user, cb, root));
            if(user.getTrainingSession() != null)
                restrictions.add(UserSpecification.isTrainingSession(user, cb, root));
            if(String.valueOf(user.getNumberTrainingAvailable()) != null)
                restrictions.add(UserSpecification.isNumberTrainingAvailable(user, cb, root));
            if(String.valueOf(user.getNumberTraining()) != null)
                restrictions.add(UserSpecification.isNumberTraining(user, cb, root));

            query.where(restrictions.toArray(new javax.persistence.criteria.Predicate[0]));
        }

        return em.createQuery(query)
                .getResultList();
    }

    @Override
    public User getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public String getRights() {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (RightEnum rightEnum : RightEnum.values()) {
            json.put("right", rightEnum);
            json.put("name", rightEnum.getValue());
            jsonArray.add(json);
            json = new JSONObject();
        }

        return jsonArray.toString();
    }

    @Override
    public ResponseEntity<MessageResponse> post(User user) {
        repository.save(user);
        return ResponseEntity.ok(new MessageResponse("User save successfully!"));
    }

    @Override
    public ResponseEntity<?> put(Integer id, User user) {
        User userById = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        if(userById != null && user != null) {
            if (user.getLastName() != null && !userById.getLastName().isEmpty() && userById.getLastName() != null) {
                if (!userById.getLastName().equals(user.getLastName())) {
                    userById.setLastName(user.getLastName());
                }
            }

            if (user.getFirstName() != null && !userById.getFirstName().isEmpty() && userById.getFirstName() != null) {
                if (!userById.getFirstName().equals(user.getFirstName())) {
                    userById.setFirstName(user.getFirstName());
                }
            }

            if (user.getBirthDate() != null && userById.getBirthDate() != null) {
                if (!userById.getBirthDate().equals(user.getBirthDate())) {
                    userById.setBirthDate(user.getBirthDate());
                }
            }

            if (user.getGender() != null && userById.getGender() != null) {
                if (!userById.getGender().equals(user.getGender())) {
                    userById.setGender(user.getGender());
                }
            }

            if (user.getAddress() != null && !userById.getAddress().isEmpty() && userById.getAddress() != null) {
                if (!userById.getAddress().equals(user.getAddress())) {
                    userById.setAddress(user.getAddress());
                }
            }

            if (user.getPostalCode() != null && !userById.getPostalCode().isEmpty() && userById.getPostalCode() != null) {
                if (!userById.getPostalCode().equals(user.getPostalCode())) {
                    userById.setPostalCode(user.getPostalCode());
                }
            }

            if (user.getCity() != null && !userById.getCity().isEmpty() && userById.getCity() != null) {
                if (!userById.getCity().equals(user.getCity())) {
                    userById.setCity(user.getCity());
                }
            }

            if (user.getCountry() != null && userById.getCountry() != null) {
                if (!userById.getCountry().equals(user.getCountry())) {
                    userById.setCountry(user.getCountry());
                }
            }

            if (user.getPhoneNumber() != null && !userById.getPhoneNumber().isEmpty() && userById.getPhoneNumber() != null) {
                if (!userById.getPhoneNumber().equals(user.getPhoneNumber())) {
                    userById.setPhoneNumber(user.getPhoneNumber());
                }
            }

            if (user.getAvailability() != null && !userById.getAvailability().isEmpty() && userById.getAvailability() != null) {
                if (!userById.getAvailability().equals(user.getAvailability())) {
                    userById.setAvailability(user.getAvailability());
                }
            }

            if (user.getTrainingSession() != null && !userById.getTrainingSession().isEmpty() && userById.getTrainingSession() != null) {
                if (!userById.getTrainingSession().equals(user.getTrainingSession())) {
                    userById.setTrainingSession(user.getTrainingSession());
                }
            }

            if (userById.getNumberTrainingAvailable() != user.getNumberTrainingAvailable())
                userById.setNumberTrainingAvailable(user.getNumberTrainingAvailable());

            if (userById.getNumberTraining() != user.getNumberTraining())
                userById.setNumberTraining(user.getNumberTraining());

            if (user.getRights() != null && userById.getRights() != null) {
                if (userById.getRights() != user.getRights())
                    userById.setRights(user.getRights());

            }

            repository.save(userById);

            return ResponseEntity.ok(new MessageResponse("User update successfully!"));
        }
        return ResponseEntity.ok(new MessageResponse("User empty !"));
    }

    @Override
    public ResponseEntity<MessageResponse> delete(Integer id) {
        repository.deleteById(id);

        return ResponseEntity.ok(new MessageResponse("User delete id {} !"));
    }
}
