package com.departEmployee.repository;

import com.departEmployee.model.Department;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ComponentScan

/*class DepartmentRowMapper implements RowMapper<Map<Department, Long>> {
    @Override
    public Map<Department, Long> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setName(resultSet.getString("name"));
        Long count = resultSet.getLong("countEmpl");
        Map<Department, Long> departEmplCount = new HashMap<>();
        departEmplCount.put(department, count);
        return departEmplCount;
    }
}*/
class DepartmentExtractor implements ResultSetExtractor<Map<Department, Long>> {
/*    @Override
    public <Map<List<Department>,Long>>

    extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Department, Long> countEmployeeInDepart = new HashMap<>();
        while (resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getLong("id"));
            department.setName(resultSet.getString("name"));
            Long countEmpl = resultSet.getLong("count");
            countEmployeeInDepart.put(department, countEmpl);
        }
        return countEmployeeInDepart;
    }*/

    @Override
    public Map<Department, Long> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Department, Long> countEmployeeInDepart = new HashMap<>();

        while (resultSet.next()) {
            Long departId = resultSet.getLong("id");
            String nameDepart = resultSet.getString("name");
            Long count = resultSet.getLong("count");

            Department department = new Department();
            department.setId(departId);
            department.setName(nameDepart);
            Long departmentList = countEmployeeInDepart.get(department);
            if (departmentList == null) {
                Department newDepart = new Department();
                newDepart.setId(departId);
                newDepart.setName(nameDepart);
                countEmployeeInDepart.put(department,count);
          /*  List<Department> list = new ArrayList<>();
            list.add(department);*/
            }

        }
        return countEmployeeInDepart;
    }
}


