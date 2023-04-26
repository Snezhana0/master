<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Book"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Publish"%> 
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Книги</title>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<aside class="leftAside">
<h3>Список книг</h3>
<table>
<thead>
<tr>
<th>Id</th>
<th>Название</th>
<th>Код</th>
<th>Год издания</th>
<th>Кол-во страниц</th>
<th>Переплёт</th>
<th>Реферат</th>
<th>Наличие на складе</th>
<th>Автор</th>
<th>Издательство</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${listBook}">
<tr>
<td>${book.getId()}</td>
<td>${book.getTitle()}</td>
<td>${book.getCode()}</td>
<td>${book.getYearpublish()}</td>
<td>${book.getCountpage()}</td>
<td>${book.getHardcover()}</td>
<td>${book.getAbstract()}</td>
<td>${book.getStatuc()}</td>
<td>${book.getAuthor()}</td>
<td>${book.getPublish()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
<section>
<article>
<h3>Данные по книге</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="lastname">Название</label>
<input type="text" name="lastname" />
</p>
<p>
<label for="firstname">Код</label>
<input type="text" name="firstname" />
</p>
<p>
<label for="phone">Год публикации</label>
<input type="text" name="phone" />
</p>
<p>
<label for="email">Кол-во страниц</label>
<input type="text" name="email" />
</p>
<p>
<label for="email">Переплёт</label>
<input type="text" name="email" />
</p>
<p>
<label for="email">Реферат</label>
<input type="text" name="email" />
</p>
<p>
<label for="email">Наличие</label>
<input type="text" name="email" />
</p>
<p>
<label for="author">Автор</label>
<select>
<option disabled>Выберите автора</option>
<c:forEach var="author" items="${listUser}">
<option value="${author}">
${author.getLastName()}
</option>
</c:forEach>
</select>
<label for="publish">Издательство</label>
<select>
<option disabled>Выберите издательство</option>
<c:forEach var="publish" items="${listPublish}">
<option value="${publish}">
${publish.getNamePublish()}
</option>
</c:forEach>
</select>
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