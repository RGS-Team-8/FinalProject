package com.codingSchool.webApp.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9@.]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final int PASSWORD_MINSIZE = 6;

    @Pattern(regexp = EMAIL_PATTERN, message = "{login.email.invalid}")
    private String email;

    @NotNull(message = "{login.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{login.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{login.password.size}")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
