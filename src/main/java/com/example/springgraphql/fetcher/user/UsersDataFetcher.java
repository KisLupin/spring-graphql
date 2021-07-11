package com.example.springgraphql.fetcher.user;

import com.example.springgraphql.model.user.User;
import com.example.springgraphql.service.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDataFetcher implements DataFetcher<List<User>> {
    private final UserService userService;

    public UsersDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> get(DataFetchingEnvironment environment) {
        return userService.findAllUsers();
    }
}
