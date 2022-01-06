<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум job4j</title>
</head>
<body>

<br><br>

<div class="container">
    <p>Вы вошли как ${user.username}</p>
    <p><a href="/logout">Выйти (logout)</a></p>
</div>

<br><br>

<div class="container">
    <p><a href="/create">Добавить новый пост</a></p>
</div>

<br><br>


<div class="container mt-3">
    <div class="row">
        <h4>Форум job4j</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Изменить</th>
                <th scope="col">Имя</th>
                <th scope="col">Пост</th>
                <th scope="col">Дата</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td> <a href='<c:url value="/edit?id=${post.id}"/>'>изменить</a> </td>
                    <td><c:out value="${post.name}"/></td>
                    <td><c:out value="${post.description}"/></td>
                    <td><c:out value="${post.created.getTime()}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>