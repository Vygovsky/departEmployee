package com.departEmployee.repository;

import com.departEmployee.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@ComponentScan
@Transactional
@Repository
public class DepartmentDAO implements ImplDepartmentDAO {
    private static final String sqlQuery = "select DEPART_ID, NAME, COUNT(E_ID) AS EMPL_COUNT FROM (SELECT E.ID   E_ID, D.ID  DEPART_ID, " +
            "D.NAME NAME FROM DEPARTMENT D LEFT JOIN EMPLOYEES E on D.ID = E.DEPARTMENT_ID) as S2 group by NAME";

    private JdbcTemplate template;
    private DepartmentExtractor departmentExtractor;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Autowired
    public void setDepartmentExtractor(DepartmentExtractor departmentExtractor) {
        this.departmentExtractor = departmentExtractor;
    }


   /* @Autowired
    public void setDepartmentRowMapper(DepartmentRowMapper departmentRowMapper) {
        this.departmentRowMapper = departmentRowMapper;
    }*/




 /*   @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }*/


}
