<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Author"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Авторы</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список авторов</h3>
<table class="table table-sm" id="table-info">
<thead>
<tr>
<th scope="col">Код</th>
<th scope="col">Имя</th>
<th scope="col">Фамилия</th>
<th scope="col">Редактировать</th>
<th scope="col">Удалить</th>
</tr>
</thead>
<tbody>
<c:forEach var="authors" items="${author}">
<tr>
<td>${authors.getId()}</td>
<td>${authors.getFirstName()}</td>
<td>${authors.getLastName()}</td>
<td width="20"><a
href='<c:url value="/editauthor?id=${authors.getId()}" />'
role="button" class="btn btn-outline-primary">
<img alt="Редактировать" src="images/edit.png" height = "30" width = "30"></a>
</td> <td width="20"><a
href='<c:url value="/deleteauthor?id=${authors.getId()}"/>'
role="button" class="btn btn-outline-primary"> <img
alt="Удалить" src="images/delete.png" height = "30" width = "30"></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Добавить автора</h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id"
class="col-sm-3 col-form-label">Код</label>
<div class="col-sm-6">
<input type="text" name="id" class="form-control"
id="staticRole" />
</div>
</div>
<div class="mb-3 row">
<label for="firstname"
class="col-sm-3 col-form-label">Имя</label>
<div class="col-sm-6">
<input type="text" name="firstname" class="form-control"
id="staticRole" />
</div>
</div>
<div class="mb-3 row">
<label for="lastname"
class="col-sm-3 col-form-label">Фамилия</label>
<div class="col-sm-6">
<input type="text" name="lastname" class="form-control"
id="staticRole" />
</div>
</div>
<p>
<button type="submit" class="btn btn-primary">
Добавить</button>
</p>
</form>
</div>
</article>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</section>
</div>
</body>
</html>