package com.github.kumarsaksham.departmentmanagement.repository;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Electronics and Communication")
                        .departmentCode("ECE-02")
                        .departmentAddress("Mumbai")
                        .build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department foundDepartment = departmentRepository.findById(1L).get();

        assertEquals(foundDepartment.getDepartmentName(), "Electronics and Communication");
    }

//    @Test
//    public void whenFindByDepartmentNameIgnoreCase_thenReturnDepartment() {
//        Department foundDepartment = departmentRepository.findByDepartmentNameIgnoreCase("Electronics and Communication");
//
//        assertEquals(foundDepartment.getDepartmentCode(), "ECE-02");
//    }
}