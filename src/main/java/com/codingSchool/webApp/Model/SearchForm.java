package com.codingSchool.webApp.Model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchForm {
    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";
    private static final String SSN_PATTERN = "^[1-9]{1}[0-9]{8}$";
    private static final int SSN_MINSIZE = 9;
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";
    private static final int PASSWORD_MINSIZE = 6;
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9]*$";

    @NotNull(message = "{insert.email.null}")
    @Pattern(regexp = EMAIL_PATTERN, message = "{insert.email.invalid}")
    private String email;

    @NotNull(message = "{insert.ssn.null}")
    @Pattern(regexp = SSN_PATTERN, message = "{insert.ssn.invalid}")
    @Size(min = SSN_MINSIZE, message = "{insert.ssn.size}")
    private String ssn;

    @NotNull(message = "{insert.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{insert.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{insert.password.size}")
    private String password;

    @Size(min=2)
    private String lastname;

    @Size(min=2)
    private String firstname;

    @Size(min=2)
    @Pattern(regexp = ADDRESS_PATTERN, message = "{insert.address.invalid}")
    private String address;

    @NotNull(message = "{insert.typeofuser.null}")
    private String typeofuser;

    @NotNull(message = "{insert.userid.invalid}")
    @Range(min=1, max=1000,message = "insert.userid.invalid")
    private long userid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeofuser() {
        return typeofuser;
    }

    public void setTypeofuser(String typeofuser) {
        this.typeofuser = typeofuser;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }
}
