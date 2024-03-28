package com.github.kumarsaksham.departmentmanagement.controller;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import com.github.kumarsaksham.departmentmanagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
//        DepartmentService departmentService = new DepartmentServiceImpl();
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok().body(savedDepartment);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        return ResponseEntity.ok().body(allDepartments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        Department fetchedDepartment = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok().body(fetchedDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.ok().body("Department Deleted successfully with id " + departmentId);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartmentById(departmentId, department);
        return ResponseEntity.ok().body(updatedDepartment);
    }

    @GetMapping("/departments/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable("name") String departmentName) {
        Department fetchedDepartment = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok().body(fetchedDepartment);
    }
}
