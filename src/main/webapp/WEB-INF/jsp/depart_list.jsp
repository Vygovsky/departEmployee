<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DepartList</title>
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css">
</head>

<body>
<div align="center"><h1>Департаменты</h1></div>
<div align="center">
    <td><h1><a href="${pageContext.request.contextPath}/add">Add Depart</a></h1></td>
</div>
<table border="1" align="center" id="customers" width="600">

    <thead align="center">

    <tr>
        <th>#</th>
        <th>Название департамента</th>
        <th>Колличество сотрудников</th>
        <th>Список сотрудников</th>
        <th>Добавить дпартамент</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>

    <tbody align="center">
    <c:forEach var="depart" items="${allListDepart}">
        <tr>
            <td>${depart.department.id}</td>
            <td>${depart.department.name}</td>
            <td>${depart.employeeAmount}</td>
            <td><a href="/listEmployee/departmentId/${depart.department.id}">List</a></td>
            <td><a href="/add/employee/${depart.department.id}">Add User</a></td>
            <td><a href="/departments/edit/${depart.department.id}">Edit</a></td>
            <td><a href="/departments/delete/${depart.department.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
