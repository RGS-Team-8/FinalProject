package com.codingSchool.webApp.Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column(nullable = false, name="ssn", unique = true)
    private String ssn;

    @Column(nullable = false, name="password")
    private String password;

    @Column(nullable = false, name="firstname")
    private String firstname;

    @Column(nullable = false, name="lastname")
    private String lastname;

    @Column(nullable = false, name="email", unique = true)
    private String email;

    @Column(nullable = false, name="address")
    private String address;

    @Column(nullable = false, name="typeofuser")
    private String typeofuser;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, targetEntity = Repair.class)
    private List<Repair> repairs;

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public User() {
    }

    public User(Long userid, String ssn, String password, String firstname, String lastname, String email, String address, String typeofuser) {
        this.userid = userid;
        this.ssn = ssn;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.typeofuser = typeofuser;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String isTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(String typeofuser) {
        this.typeofuser = typeofuser;
    }

    public String getTypeofuser() {
        return typeofuser;
    }
}
