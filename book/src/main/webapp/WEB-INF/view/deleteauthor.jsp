<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Author"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<head>
<meta charset="UTF-8">
<title>Удаление автора</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список</h3>
<table class="table table-sm" id="table-info">
<thead>
<tr>
<th scope="col">Код</th>
<th scope="col">Имя</th>
<th scope="col">Фамилия</th>
</tr>
</thead>
<tbody>
<c:forEach var="authors" items="${author}">
<tr>
<td>${authors.getId()}</td>
<td>${authors.getFirstName()}</td>
<td>${authors.getLastName()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Удаление автора</h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id" class="col-sm-4 col-form-label">Код Автора</label>
<div class="col-sm-6">
<input type="text" class="form-control" readonly
value="${authorsDelete[0].getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="firstname" class="col-sm-4 col-form-label">Имя</label>
<div class="col-sm-6">
<input type="text" class="form-control" name="firstname" readonly
value="${authorsDelete[0].getFirstName()}" />
</div>
</div>
<div class="mb-3 row">
<label for="lastname" class="col-sm-4 col-form-label">Фамилия</label>
<div class="col-sm-6">
<input type="text" class="form-control" name="lastname" readonly
value="${authorsDelete[0].getLastName()}" />
</div>
</div>
<button type="submit" class="btn btn-primary">Удалить</button>
<a href='<c:url value="/authors" />' role="button"
class="btn btn-secondary">Отменить/Возврат</a>
</form>
</div>
</article>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</section>
</div>
</body>
</html>
