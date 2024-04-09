package com.github.kumarsaksham.departmentmanagement.service;

import com.github.kumarsaksham.departmentmanagement.entity.Department;
import com.github.kumarsaksham.departmentmanagement.exception.DepartmentNotFoundException;
import com.github.kumarsaksham.departmentmanagement.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            LOGGER.error("Department with ID: {} not found", departmentId);
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department fetchedDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            fetchedDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            fetchedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            fetchedDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(fetchedDepartment);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
