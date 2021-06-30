package com.example.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

    @Column
    private String name;
    @Column
    private String mobileNumber;
    @Column
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Person(@JsonProperty("name") String name, @JsonProperty("mobileNumber") String mobileNumber, @JsonProperty("email") String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
