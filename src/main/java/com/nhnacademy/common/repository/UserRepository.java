package com.nhnacademy.common.repository;

import com.nhnacademy.common.object.dataStructure.User;
import com.nhnacademy.user.EndUser;
import java.util.List;

public interface UserRepository {
    void add(User user);
    void modify(User user);
    User remove(String id);

    User getUser(String id);
    List<EndUser> getUsers();
}
