<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/editSave?id=${post.id}'/>" method='POST'>
    <table>
        <tr>
            <td><label>ID (для инфо)
                <input type='text' name='id' value="${post.id}" readonly>
            </label></td>
        </tr>

        <tr>
            <td><label>Имя
                <input type='text' name='name' value="${post.name}">
            </label></td>
        </tr>

        <tr>
            <td><label>Описание
                <input type='text' name='description' value="${post.description}">
            </label></td>
        </tr>

        <tr>
            <td><label>Дата (для инфо)
                <input type='text' name='${post.created}' value="${post.created.getTime()}" readonly>
            </label></td>
        </tr>

        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>