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
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<aside class="leftAside">
<h3>Список книг</h3>
<table>
<thead>
<tr>
<th>Код</th>
<th>Название</th>
<th>Код</th>
<th>Год публикации</th>
<th>Кол-во страниц</th>
<th>Переплёт</th>
<th>Реферат</th>
<th>Наличие</th>
<th>Автор</th>

<th>Издательство</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}">
<tr>
<td>${book.getId()}</td>
<td>${book.getTitle()}</td>
<td>${book.getCode()}</td>
<td>${book.getYearpublish()}</td>
<td>${book.getCountpage()}</td>
<td>${book.getHardcover()}</td>
<td>${book.getAbstract()}</td>
<td>${book.getHardcover()}</td>
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
<label for="id">Id</label>
<input type="text" name="id" />
</p>
<p>
<label for="title">Название</label>
<input type="text" name="title" />
</p>
<p>
<label for="code">Код</label>
<input type="text" name="code" />
</p>
<p>
<p>
<label for="yearpublish">Год публикации</label>
<input type="text" name="yearpublish" />
</p>
<p>
<label for="countpage">Кол-во страниц </label>
<input type="text" name="countpage" />
</p>
<p>
<label for="hardcover">Переплёт</label>
<input type="text" name="Hardcover" />
</p>
<p>
<label for="abstract">Реферат</label>
<input type="text" name="Abstract" />
</p>
<p>
<label for="statuc">Наличие</label>
<input type="text" name="Statuc" />
</p>
<label for="authorid">Автор</label>
<select name = "author">
<option disabled>Выберите автора</option>
<c:forEach var="author" items="${authors}">
<option value="${author}">
<c:out value="${author.getLastName()}"></c:out>
</option>
</c:forEach>
</select>
<label for="publishid">Издательство</label>
<select name = "publish">
<option disabled>Выберите издательство</option>
<c:forEach var="publish" items="${publishs}">
<option value="${publish}">
<c:out value="${publish.getNamePublish()}"></c:out>
</option>
</c:forEach>
</select>
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