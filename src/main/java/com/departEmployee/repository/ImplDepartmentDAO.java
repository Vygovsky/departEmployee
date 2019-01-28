package com.departEmployee.repository;

import com.departEmployee.model.Department;

import java.util.Map;

public interface ImplDepartmentDAO {
    Map<Department, Long> findCountEmplInDepartments();

}
