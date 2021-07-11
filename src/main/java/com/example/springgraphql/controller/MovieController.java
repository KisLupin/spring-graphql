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
@RequestMapping("/movie")
public class MovieController {
    private final GraphQL graphQL;

    MovieController(GraphQlUtility graphQlUtility) throws IOException {
        graphQL = graphQlUtility.createGraphQlObject();
    }

    @PostMapping()
    public ResponseEntity movieAll(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return ResponseEntity.ok(result.getData());
    }


    @PostMapping("/paging")
    public ResponseEntity moviePageing(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return ResponseEntity.ok(result.getData());
    }
}
