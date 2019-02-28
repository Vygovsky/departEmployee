package com.departEmployee.service;

import com.departEmployee.model.Department;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartService {

    Iterable<Department> getAllDepartments();

    Optional<Department> getDepartByIdDepartment(Long id);

    void saveOrUpdateDepartment(Department department);

    void deleteDepartment(Long id);

    Department findByName(String nameDepartment);

    Map<Department, Long> findCountEmplInDepartments2();



}
