package com.inscription.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inscription.spring.bean.enums.CountryEnum;
import com.inscription.spring.bean.enums.GenderEnum;
import com.inscription.spring.bean.enums.RightEnum;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private Date birthDate;

    @Column
    private GenderEnum gender;

    @Column
    private String address;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private CountryEnum country;

    @Column
    private String phoneNumber;

    @Column
    private String availability;

    @Column
    private String trainingSession;

    @Column
    private int numberTrainingAvailable;

    @Column
    private int numberTraining;

    @Column
    @ElementCollection(targetClass=RightEnum.class)
    private List<RightEnum> rights = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public User() {
    }

    public User(String lastName, String firstName, Date birthDate, GenderEnum gender, String address, String postalCode, String city, CountryEnum country, String phoneNumber, String availability, String trainingSession, int numberTrainingAvailable, int numberTraining, List<RightEnum> rights, Team team) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.availability = availability;
        this.trainingSession = trainingSession;
        this.numberTrainingAvailable = numberTrainingAvailable;
        this.numberTraining = numberTraining;
        this.rights = rights;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(String trainingSession) {
        this.trainingSession = trainingSession;
    }

    public int getNumberTrainingAvailable() {
        return numberTrainingAvailable;
    }

    public void setNumberTrainingAvailable(int numberTrainingAvailable) {
        this.numberTrainingAvailable = numberTrainingAvailable;
    }

    public int getNumberTraining() {
        return numberTraining;
    }

    public void setNumberTraining(int numberTraining) {
        this.numberTraining = numberTraining;
    }

    public List<RightEnum> getRights() {
        return rights;
    }

    public void setRights(List<RightEnum> rights) {
        this.rights = rights;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", availability='" + availability + '\'' +
                ", trainingSession='" + trainingSession + '\'' +
                ", numberTrainingAvailable=" + numberTrainingAvailable +
                ", numberTraining=" + numberTraining +
                ", rights=" + rights +
                ", team=" + team +
                '}';
    }
}
