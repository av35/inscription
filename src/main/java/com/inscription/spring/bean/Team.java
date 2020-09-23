package com.inscription.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.Group;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team")
    private List<User> users;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", association=" + association +
                '}';
    }
}
