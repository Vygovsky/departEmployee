package com.departEmployee.service;

import com.departEmployee.model.Department;

import java.util.Map;
import java.util.Optional;

public interface DepartService {

    Iterable<Department> getAllDepartments();

    Optional<Department> getDepartByIdDepartment(Long id);

    void saveOrUpdateDepartment(Department department);

    void deleteDepartment(Long id);

    Department findByName(String nameDepartment);

  //  Map<Long, Long> findCountEmplInDepartments();

    Map <Object,Long> findCountEmplInDepartments2();

}
