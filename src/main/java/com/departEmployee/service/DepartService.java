package com.departEmployee.service;

import com.departEmployee.model.Department;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DepartService {

    Iterable <Department> getAllDepartments();

    Optional<Department> getDepartByIdDepartment(Long id);

    void saveOrUpdateDepartment(Department department);

    void deleteDepartment(Long id);

    Department findByName(String nameDepartment);

}
