package com.inscription.spring.specification;

import com.inscription.spring.bean.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification {

    public static Predicate isFirstName(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("firstName"), "%" + user.getFirstName() + "%");
    }

    public static Predicate isLastName(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("lastName"), "%" + user.getLastName() + "%");
    }

    public static Predicate isBirthDate(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("birthDate"), "%" + user.getBirthDate() + "%");
    }

    public static Predicate isGender(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("gender"), "%" + user.getGender() + "%");
    }

    public static Predicate isPostalCode(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("postalCode"), "%" + user.getPostalCode() + "%");
    }

    public static Predicate isCity(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("city"), "%" + user.getCity() + "%");
    }

    public static Predicate isCountry(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("country"), "%" + user.getCountry() + "%");
    }

    public static Predicate isPhoneNumber(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("phoneNumber"), "%" + user.getPhoneNumber() + "%");
    }

    public static Predicate isAvailability(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("availability"), "%" + user.getAvailability() + "%");
    }

    public static Predicate isTrainingSession(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.like(root.get("trainingSession"), "%" + user.getTrainingSession() + "%");
    }

    public static Predicate isNumberTrainingAvailable(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.equal(root.get("numberTrainingAvailable"), user.getNumberTrainingAvailable());
    }

    public static Predicate isNumberTraining(User user, CriteriaBuilder cb, Root<User> root) {
        return cb.equal(root.get("numberTraining"), user.getNumberTraining());
    }
}
