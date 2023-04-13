<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Author"%>
<%
Author a1 = new Author(1l, "Джон Рональд Руэл ", "Толкин");
Author a2 = new Author(2l, "Сергей ", "Довлатов");
Author a3= new Author(3l, "Кир ", " Булычёв");
Author a4 = new Author(4l, "Стефани ", "Майер");
Author[] authors = new Author[]{a1, a2, a3, a4};
int length = authors.length;
pageContext.setAttribute("authors", authors);
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Авторы</title>
<head>
<meta charset="UTF-8">
<title>Authors</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список Авторов</h3>
<table>
<thead>
<tr>
<th scope="col">Код</th>
<th scope="col">Имя</th>
<th scope="col">Фамилия</th>
</tr>
</thead>
<tbody>
<c:forEach var="author" items="${authors}">
<tr>
<td>${author.getId()}</td>
<td>${author.getFirstName()}</td>
<td>${author.getLastName()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Авторы</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="namerole">Автор
</label> <input type="text" name="namerole" />
</p>
</form>
<p>
<button type="submit">Добавить</button>
</p>
</div>
</article>
</section>
</div>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>