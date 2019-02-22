<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create depart</title>
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css">

<body>
<div align="center">
    <h1>Создать департамент</h1>
</div>


<form method="POST" action="/departments/update/${editDepart.get().id}">

    <div class="form-style-6">
        <table>

            <td>Имя департамента :</td>
            <td><label>
                <input type="text" name="name"
                       value="<c:out value="${editDepart.get().name}" />"/>
            </label><br></td>

            <tr>
                <td><input type="submit" value="Отправить"></td>
                &nbsp;&nbsp;&nbsp;
                <td><input type="button" value="Отмена" onclick='location.href="/"'></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>



