package com.departEmployee.service;

import com.departEmployee.model.Department;
import com.departEmployee.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartServiceImpl implements DepartService {

    private DepartRepository departRepository;

    @Autowired
    public void setDepartRepository(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }

    @Override
    public Iterable<Department> getAllDepartments() {
        return departRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartByIdDepartment(Long id) {
        return departRepository.findById(id);
    }

    @Override
    public void saveOrUpdateDepartment(Department department) {
        departRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departRepository.deleteById(id);
    }

    @Override
    public Department findByName(String nameDepartment) {
        return departRepository.findByName(nameDepartment);
    }

    @Override
    public Map<Department, Long> findCountEmplInDepartments2() {
        return departRepository.findCountEmplInDepartments2();
    }

}
