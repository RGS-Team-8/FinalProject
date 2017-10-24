package com.codingSchool.webApp.Converters;

import com.codingSchool.webApp.Domain.User;
import com.codingSchool.webApp.Model.SearchForm;

public class UserUpdater {
    public static User updateUserObject(SearchForm searchForm) {
        User user = new User();
        user.setUserid(searchForm.getUserid());
        user.setAddress(searchForm.getAddress());
        user.setEmail(searchForm.getEmail());
        user.setFirstname(searchForm.getFirstname());
        user.setLastname(searchForm.getLastname());
        user.setSsn(searchForm.getSsn());
        user.setPassword(searchForm.getPassword());
        user.setTypeofuser(searchForm.getTypeofuser());

        return user;
    }
}
