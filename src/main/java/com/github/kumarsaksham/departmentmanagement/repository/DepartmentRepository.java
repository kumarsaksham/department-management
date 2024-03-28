package com.github.kumarsaksham.departmentmanagement.repository;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);

    Department findByDepartmentNameIgnoreCase(String departmentName);

//    Instead of JPA Methods, we can use JPQL Or Native SQL Query
//    @Query(value = "SQLQuery", nativeQuery = true)
//    Department findByDepartmentNameIgnoreCase(String departmentName);


}
