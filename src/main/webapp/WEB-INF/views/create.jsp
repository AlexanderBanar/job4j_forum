<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form  action="<c:url value='/createSave'/>" method='POST'>
    <table>
        <tr>
            <td><label>Имя
                <input type='text' name='name'>
            </label></td>
        </tr>

        <tr>
            <td><label>Описание
                <input type='text' name='desc'>
            </label></td>
        </tr>

        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>