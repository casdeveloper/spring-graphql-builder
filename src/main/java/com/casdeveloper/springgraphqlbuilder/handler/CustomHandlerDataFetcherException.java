package com.casdeveloper.springgraphqlbuilder.handler;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import graphql.language.SourceLocation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.util.List;

public class CustomHandlerDataFetcherException implements DataFetcherExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomHandlerDataFetcherException.class);

    private final Clock clock;

    public CustomHandlerDataFetcherException(){
        this(Clock.systemDefaultZone());
    }

    public CustomHandlerDataFetcherException(Clock clock) {
        this.clock = clock;
    }

    @Override
    public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters dataFetcherExceptionHandlerParameters) {

        Throwable exception = dataFetcherExceptionHandlerParameters.getException();
        logger.error("Error processing request");
        GraphQLError error;
        if (exception instanceof GraphQLError){
            error = (GraphQLError) exception;
        } else {

            error = (GraphQLError) new GraphQLException("Other error");
        }
        return StringUtils.isNotBlank(error.getMessage()) ? DataFetcherExceptionHandlerResult.newResult().error(error).build() : DataFetcherExceptionHandlerResult.newResult().errors((List<GraphQLError>) error).build();
    }
}
