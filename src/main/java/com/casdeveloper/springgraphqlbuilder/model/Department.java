package com.casdeveloper.springgraphqlbuilder.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "DEPARTMENT")
@GraphQLType(name = "DEPARTMENT", description = "Department class")
public class Department {

    @Id
    @Column(name = "ID")
    @GraphQLQuery(name = "ID", description = "Department identifier")
    private Long id;

    @Column(name = "DESCRIPTION")
    @GraphQLQuery(name = "DESCRIPTION", description = "Description")
    private String description;
}
