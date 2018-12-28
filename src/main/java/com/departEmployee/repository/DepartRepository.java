package com.departEmployee.repository;

import com.departEmployee.model.Department;
import com.departEmployee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends CrudRepository<Department, Long> {

    Department findByName(String nameDepartment);
}
