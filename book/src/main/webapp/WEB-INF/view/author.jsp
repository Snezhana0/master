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
<title></title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список авторов</h3>
<table>
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
<h3>Данные автора</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="id">Id</label>
<input type="text" name="id" />
</p>
<p>
<label for="firstname">Имя</label>
<input type="text" name="firstname" />
</p>
<p>
<label for="lastname">Фамилия</label>
<input type="text" name="lastname" />
</p>
<p>
<button type="submit">Добавить</button>
</p>
</form>
</div>
</article>
</section>
</div>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>