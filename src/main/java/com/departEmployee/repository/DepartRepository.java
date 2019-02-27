package com.departEmployee.repository;

import com.departEmployee.model.Department;
import com.departEmployee.model.DepartmentEmployeeStats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Map;

@Repository
public interface DepartRepository extends CrudRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE LOWER(d.name) = LOWER(:departName)")
    Department findByName(@Param("departName") String departName);

    @Query(nativeQuery = true, value = "select DEPART_ID, NAME, COUNT(E_ID) AS EMPL_COUNT \n" +
            "FROM (SELECT E.ID   E_ID, D.ID   DEPART_ID, D.NAME NAME \n" +
            "FROM DEPARTMENT D LEFT JOIN EMPLOYEES E on D.ID = E.DEPARTMENT_ID) as S2 group by NAME")
    Map<Department, Long> findCountEmplInDepartments2();

    @Query("SELECT new com.departEmployee.model.DepartmentEmployeeStats(d) " +    // тут мы возвращаем лист новых обьектов DepartmentEmployeeStats вместо кучи полей как обычно происходит при селекте и передаем в конструктор объект депрата
            "FROM Department d LEFT JOIN d.employees GROUP BY d")                 // департы джойним left джойном с эмплами, чтоб не потерять департ без эмплов иначе в листе итоговом будет всего 3 из 4-х департов, ну ты видел при дебаге
    List<DepartmentEmployeeStats> findEmployeeCountByDepartment();                // подсчет количества эмплов мы перенесли в конструктор, потому как здесь не получалось сделать так чтоб 0 эмплов сохранялось если employees=NULL, не исключено что это возможно подсчитать и в квере, но я не нашел как, поэтому в конструкторе считаем

    @Query(nativeQuery = true, value = "select DEPART_ID, NAME, COUNT(E_ID) AS EMPL_COUNT\n" +
            "FROM (SELECT E.ID   E_ID, D.ID   DEPART_ID, D.NAME NAME\n" +
            "FROM DEPARTMENT D LEFT JOIN EMPLOYEES E on D.ID = E.DEPARTMENT_ID) as S2 group by NAME")
    List<Department> findCountEmplInDepartmentsList();
}
