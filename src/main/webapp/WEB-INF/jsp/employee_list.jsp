
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        #customers {
            border: solid 1px #DDEEEE;
            border-collapse: collapse;
            border-spacing: 0;
            font: normal 13px Arial, sans-serif;
        }

        #customers td, #customers th {
            border: solid 1px #DDEEEE;
            color: #333;
            padding: 10px;

        }

        #customers tr:nth-child(even) {
            background-color: #DDEFEF;
            border: solid 1px #DDEEEE;
            color: #336B6B;
            padding: 10px;
            text-align: left;
            text-shadow: 1px 1px 1px #fff;
        }

        #customers tr:hover {
            background-color: #fff;
        }

        #customers tbody tr:nth-child(even) {
            background-color: #EEF7EE;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #86af90;
            color: white;
        }

        div {
        }

        #left {
            text-align: left;
        }

        #right {
            text-align: right;
        }

        #center {
            text-align: center;
        }

        .content {
            width: 75%; /* Ширина слоя */
            background: #fc0; /* Цвет фона */
        }
    </style>
<body>
<div align="center">
    <h1>List users by departments</h1>
</div>
<div align="center">
    <td><h1><a href="/add/employee/${departmentId}">Add User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/">Depart-menu</a></h1></td>

</div>
<table align="center" id="customers" width="600">
    <%--<table id="customers">--%>
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>Birthday</th>
        <th>Department</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.birthday}</td>
            <td>${employee.department.name}</td>

            <form action="/add/employee/${departmentId}" method="post">
                <td><a href="/employee/create?action=edit&id=${employee.id}&currentDepartId=${departmentId}">Edit</a></td>
            </form>
           <%-- <td><a href="/employee/create?action=delete&id=${employee.id}&departmentId=${departmentId}">Delete</a></td>--%>
            <td><a href="/employee/delete/${employee.id}">Delete</a></td>

        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
