package com.github.kumarsaksham.departmentmanagement.service;

import com.github.kumarsaksham.departmentmanagement.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
