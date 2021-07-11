package com.example.springgraphql.fetcher.user;

import com.example.springgraphql.model.user.User;
import com.example.springgraphql.service.UserService;
import graphql.language.Field;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserDataFetcher implements DataFetcher<User> {
    private final UserService userService;

    public UserDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User get(DataFetchingEnvironment environment) {
        Map arg = environment.getArguments();
        return userService.findOneById(new ObjectId(String.valueOf(arg.get("id"))));
    }
}
