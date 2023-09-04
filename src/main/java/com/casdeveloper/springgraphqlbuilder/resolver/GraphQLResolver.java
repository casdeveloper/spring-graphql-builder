package com.casdeveloper.springgraphqlbuilder.resolver;

import com.casdeveloper.springgraphqlbuilder.model.Department;
import com.casdeveloper.springgraphqlbuilder.service.GenericService;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
@RequiredArgsConstructor
public class GraphQLResolver {

    @Autowired
    GenericService genericService;

    @GraphQLQuery(name = "getAllDepartment", description = "Return all departments")
    public List<Department> getAllDepartment(){
        List<Department> resultList = genericService.getAllDepartment();
        return resultList;
    }
}
