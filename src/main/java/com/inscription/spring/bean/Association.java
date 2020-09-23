package com.inscription.spring.bean;

import com.inscription.spring.bean.enums.AssociationTypeEnum;
import com.inscription.spring.bean.enums.CountryEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="associations")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String name;

    @Column
    private Date creationDate;

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
    private AssociationTypeEnum associationTypeEnum;

    @OneToMany(mappedBy = "association")
    private List<Team> teams;

    public Association() {
    }

    public Association(String name, Date creationDate, String address, String postalCode, String city, CountryEnum country, String phoneNumber, AssociationTypeEnum associationTypeEnum, List<Team> teams) {
        this.name = name;
        this.creationDate = creationDate;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.associationTypeEnum = associationTypeEnum;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public AssociationTypeEnum getAssociationTypeEnum() {
        return associationTypeEnum;
    }

    public void setAssociationTypeEnum(AssociationTypeEnum associationTypeEnum) {
        this.associationTypeEnum = associationTypeEnum;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", associationTypeEnum=" + associationTypeEnum +
                ", teams=" + teams +
                '}';
    }
}
