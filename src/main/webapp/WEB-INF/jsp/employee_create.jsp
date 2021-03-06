<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css">
    <style>.error {
        color: red;
    }

    .success {
        color: green;
    }</style>
</head>


<body>

<div align="center">
    <h1>Создать сотрудника</h1>
</div>
<form method="POST" action="/save/employee">
    <div class="form-style-6">
        <table>
            <tr>
                <td>Имя сотрудника :</td>
                <td><input type="text" name="name" required value="<c:out value="${sessionScope.employee.name}"/>${employee.name}"/><br></td>
                <c:if test="${not empty errors}">
                    <span style="color:red"><c:out value="${sessionScope.errors[\"errorNameMessage\"]}"/></span>
                </c:if>
                <br/>
            </tr>
            <tr>
                <td> Электронная почта :</td>
                <td><input type="text" name="email" required value="<c:out value="${sessionScope.employee.email}"/>${employee.email}"/></td>
                <c:if test="${not empty errors}">
                    <span style="color:red"><c:out value="${sessionScope.errors[\"errorEmailMessage\"]}"/></span>
                </c:if>
                <br/>

            </tr>
            <tr>
                <td>Дата рождения :</td>
                <td><input type="date" name="birthday" required value="${sessionScope.employee.birthday}">${employee.birthday}</td>
                <c:if test="${not empty errors}">
                    <span style="color:red"><c:out value="${sessionScope.errors[\"errorBdMessage\"]}"/></span>
                </c:if>
                <br/>
            </tr>
            <tr>
                <td>Департамент :</td>
                <td><label>

                    <select name="department">
                        <c:forEach var="depart" items="${departments}">
                            <option value="${depart.id}"
                                ${depart.id == currentDepartId ? 'selected="selected"' : null}>${depart.name}</option>
                        </c:forEach>
                    </select>
                </label>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Отправить"></td>
                <span class="success">${message.success}</span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <td><input type="button" value="Отмена"
                           onclick='location.href="/"'></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>
