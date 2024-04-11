package com.github.kumarsaksham.departmentmanagement.service;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import com.github.kumarsaksham.departmentmanagement.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        // using @Builder pattern to build the department object.
        Department department =
                Department.builder()
                        .departmentName("CSE")
                        .departmentId(1L)
                        .departmentAddress("Bangalore")
                        .departmentCode("CSE-01")
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String departmentName = "CSE";
        Department foundDepartment = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}