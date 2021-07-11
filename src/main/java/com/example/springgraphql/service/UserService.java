package com.example.springgraphql.service;

import com.example.springgraphql.model.user.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    User findOneById(ObjectId id);
    List<User> findAllUsers();
}
