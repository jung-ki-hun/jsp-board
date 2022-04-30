package com.nhnacademy.user;

import com.nhnacademy.common.object.dataStructure.User;
import com.nhnacademy.common.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class EndUserRepository implements UserRepository {
    private static EndUserRepository endUserRepository = null;
    List<EndUser> userRepository = new ArrayList<>();
    private EndUserRepository(){
        throw new UnsupportedOperationException();
    };
    public static EndUserRepository getInstance(){
        if(endUserRepository == null)
        {
            endUserRepository = new EndUserRepository();
        }
        return endUserRepository;
    }
    @Override
    public void add(User user) {
        userRepository.add((EndUser)user);
    }

    @Override
    public void modify(User user) {
        EndUser temp =(EndUser) user;
        int index = userRepository.indexOf(temp);
        if(index != -1) {
            userRepository.set(index,(EndUser)user);
        }
        if(index == -1)
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public User remove(String id) {
 userRepository.remove(getUser(id));
        return null;
    }

    @Override
    public User getUser(String id) {
        int size = userRepository.size();
        for (int i = 0; i < size; i++) {
            if(userRepository.get(i).getId().equals(id))
                return userRepository.get(i);
        }
        return null;
    }

    @Override
    public List<EndUser> getUsers() {
        return userRepository;
    }
}
