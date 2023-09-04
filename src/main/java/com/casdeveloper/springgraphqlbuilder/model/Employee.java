package com.casdeveloper.springgraphqlbuilder.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE")
@GraphQLType(name = "EMPLOYEE", description = "Employee class")
public class Employee {

    @Id
    @Column(name = "ID")
    @GraphQLQuery(name = "ID", description = "Employee identifier")
    private Long id;

    @Column(name = "NAME")
    @GraphQLQuery(name = "NAME", description = "Name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT", referencedColumnName = "ID")
    @GraphQLQuery(name = "DEPARTMENT", description = "Allocation department")
    private Department department;

}
