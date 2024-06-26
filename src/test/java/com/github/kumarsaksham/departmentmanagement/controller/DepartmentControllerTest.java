package com.github.kumarsaksham.departmentmanagement.controller;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import com.github.kumarsaksham.departmentmanagement.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("CSE")
                        .departmentCode("CSE-01")
                        .departmentAddress("Bangalore")
                        .build();
    }

    @Test
    public void saveDepartment() throws Exception {
        Department inputDepartment =
                Department.builder()
                        .departmentName("CSE")
                        .departmentCode("CSE-01")
                        .departmentAddress("Bangalore")
                        .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"departmentName\":\"CSE\",\"departmentAddress\":\"Bangalore\",\"departmentCode\":\"CSE-01\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}