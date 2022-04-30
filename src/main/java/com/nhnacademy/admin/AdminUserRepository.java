package com.nhnacademy.admin;

import com.nhnacademy.common.object.dataStructure.User;
import com.nhnacademy.common.repository.UserRepository;
import com.nhnacademy.user.EndUser;
import java.util.List;

public class AdminUserRepository implements UserRepository {
    @Override
    public void add(User user) {

    }

    @Override
    public void modify(User user) {

    }

    @Override
    public User remove(String id) {
        return null;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public List<EndUser> getUsers() {
        return null;
    }
}
