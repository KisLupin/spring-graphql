package com.example.springgraphql.graph;

import com.example.springgraphql.fetcher.movie.MoviesDataFetcher;
import com.example.springgraphql.fetcher.movie.MovieDataFetcher;
import com.example.springgraphql.fetcher.movie.MoviesPagingFetcher;
import com.example.springgraphql.fetcher.user.UserDataFetcher;
import com.example.springgraphql.fetcher.user.UsersDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQlUtility {
    @Value("classpath:graphql/data.graphqls")
    private Resource schemaResource;
    private final MovieDataFetcher movieDataFetcher;
    private final MoviesDataFetcher moviesDataFetcher;
    private final MoviesPagingFetcher moviesPagingFetcher;
    private final UserDataFetcher userDataFetcher;
    private final UsersDataFetcher usersDataFetcher;

    public GraphQlUtility(MovieDataFetcher movieDataFetcher, MoviesDataFetcher moviesDataFetcher,
                          MoviesPagingFetcher moviesPagingFetcher, UserDataFetcher userDataFetcher,
                          UsersDataFetcher usersDataFetcher) {
        this.movieDataFetcher = movieDataFetcher;
        this.moviesDataFetcher = moviesDataFetcher;
        this.moviesPagingFetcher = moviesPagingFetcher;
        this.userDataFetcher = userDataFetcher;
        this.usersDataFetcher = usersDataFetcher;
    }

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("movies", moviesDataFetcher)
                        .dataFetcher("movie", movieDataFetcher)
                        .dataFetcher("moviesPaging", moviesPagingFetcher)
                        .dataFetcher("user", userDataFetcher)
                        .dataFetcher("users", usersDataFetcher)
                )
                .build();
    }
}
