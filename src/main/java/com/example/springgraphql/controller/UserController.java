package com.example.springgraphql.controller;

import com.example.springgraphql.graph.GraphQlUtility;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final GraphQL graphQL;

    public UserController(GraphQlUtility graphQlUtility) throws IOException {
        this.graphQL = graphQlUtility.createGraphQlObject();
    }

    @PostMapping()
    public ResponseEntity userAll(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return ResponseEntity.ok(result.getData());
    }
}
