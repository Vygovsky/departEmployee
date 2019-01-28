package com.departEmployee.repository;

import com.departEmployee.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public interface DepartRepository extends CrudRepository<Department, Long> {

    @Query(nativeQuery = true, value = "select  depart_Id, COUNT(E_ID) AS EMPL_COUNT FROM (SELECT E.ID E_ID,D.ID depart_id\n" +
            "FROM DEPARTMENT D LEFT JOIN EMPLOYEES E on D.ID = E.DEPARTMENT_ID) as S2 group by depart_id;")
    Map<Long, Long> findCountEmplInDepartments();

    @Query("SELECT d FROM Department d WHERE LOWER(d.name) = LOWER(:departName)")
    Department findByName(@Param("departName") String departName);

    @Query(nativeQuery = true, value = "select DEPART_ID, NAME, COUNT(E_ID) AS EMPL_COUNT\n" +
            "FROM (SELECT E.ID   E_ID, D.ID   DEPART_ID, D.NAME NAME\n" +
            "FROM DEPARTMENT D LEFT JOIN EMPLOYEES E on D.ID = E.DEPARTMENT_ID) as S2 group by NAME")
    Map<Object, Long> findCountEmplInDepartments2();

}
