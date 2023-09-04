package com.casdeveloper.springgraphqlbuilder.repository;

import com.casdeveloper.springgraphqlbuilder.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
