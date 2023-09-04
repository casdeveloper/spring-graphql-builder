package com.casdeveloper.springgraphqlbuilder.configuration;

import com.casdeveloper.springgraphqlbuilder.handler.CustomHandlerDataFetcherException;
import com.casdeveloper.springgraphqlbuilder.resolver.GraphQLResolver;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.AsyncSerialExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQLConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(GraphQLConfiguration.class);

    @Bean
    public GraphQL schemaBuilder(GraphQLResolver resolver){
        logger.info("Building GraphQL Schema");

        GraphQLSchema graphQLSchema = new GraphQLSchemaGenerator()
                .withBasePackages("com.casdeveloper.springgraphqlbuilder")
                .withResolverBuilders(
                        new AnnotatedResolverBuilder(),
                        new PublicResolverBuilder("com.casdeveloper.springgraphqlbuilder")
                )
                .withOperationsFromSingleton(resolver, GraphQLResolver.class)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();

        logger.info("GraphQL Schema generated successfully");

        return GraphQL.newGraphQL(graphQLSchema)
                .queryExecutionStrategy( new AsyncExecutionStrategy(new CustomHandlerDataFetcherException()))
                .mutationExecutionStrategy(new AsyncSerialExecutionStrategy(new CustomHandlerDataFetcherException()))
                .build();
    }
}
