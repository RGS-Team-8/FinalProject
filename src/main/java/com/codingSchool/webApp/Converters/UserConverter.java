package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.InsertForm;

public class UserConverter {
    public static User buildUserObject(InsertForm insertForm) {
        User user = new User();
        user.setAddress(insertForm.getAddress());
        user.setEmail(insertForm.getEmail());
        user.setFirstname(insertForm.getFirstname());
        user.setLastname(insertForm.getLastname());
        user.setSsn(insertForm.getSsn());
        user.setPassword(insertForm.getPassword());
        user.setTypeofuser(insertForm.getTypeofuser());

        return user;
    }
}
