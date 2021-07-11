package com.example.springgraphql.service.impl;

import com.example.springgraphql.model.user.User;
import com.example.springgraphql.repository.UserRepository;
import com.example.springgraphql.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOneById(ObjectId id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
