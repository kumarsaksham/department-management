package com.github.kumarsaksham.departmentmanagement.controller;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import com.github.kumarsaksham.departmentmanagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Invoking saveDepartment api for saving the department details");
//        DepartmentService departmentService = new DepartmentServiceImpl();
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok().body(savedDepartment);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        LOGGER.info("Invoking getAllDepartments api for fetching the department details");
        List<Department> allDepartments = departmentService.getAllDepartments();
        return ResponseEntity.ok().body(allDepartments);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Invoking getDepartmentById api for fetching the department detail by Id");
        Department fetchedDepartment = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok().body(fetchedDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Invoking deleteDepartmentById api for deleting the department detail by Id");
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.ok().body("Department Deleted successfully with id " + departmentId);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        LOGGER.info("Invoking updateDepartmentById api for updating the department detail by Id");
        Department updatedDepartment = departmentService.updateDepartmentById(departmentId, department);
        return ResponseEntity.ok().body(updatedDepartment);
    }

    @GetMapping("/departments/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("Invoking getDepartmentByName api for fetching the department detail by Department Name");
        Department fetchedDepartment = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok().body(fetchedDepartment);
    }
}
