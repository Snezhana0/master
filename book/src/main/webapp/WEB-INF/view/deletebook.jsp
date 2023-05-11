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
<title>Удаление книги</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<aside class="leftAside">
<h3>Список книг</h3>
<table class="table table-sm" id="table-info">
<thead>
<tr>
<th>Id</th>
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
<h3>Удалить книгу</h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id" class="col-sm-4 col-form-label">Id</label>
<div class="col-sm-6">
<input type="text" class="form-control" readonly
value="${booksDelete[0].getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="title" class="col-sm-4 col-form-label">Название</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticLastname"
readonly
name="title" value="${booksDelete[0].getTitle()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="code" class="col-sm-4 col-form-label">Код</label>
35
<div class="col-sm-6">
<input type="text" class="form-control" id="staticFirstname"
readonly
name="code" value="${booksDelete[0].getCode()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="yearpublish" class="col-sm-4 col-form-label">Год публикации</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticLastname"
readonly
name="yearpublish" value="${booksDelete[0].getYearpublish()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="countpage" class="col-sm-4 col-form-label">Кол-во страниц</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticFirstname"
readonly
name="countpage" value="${booksDelete[0].getCountpage()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="hardcover" class="col-sm-4 col-form-label">Переплёт</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticFirstname"
readonly
name="hardcover" value="${booksDelete[0].getHardcover()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="abstract" class="col-sm-4 col-form-label">Реферат</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticphone" readonly
name="abstract" value="${booksDelete[0].getAbstract()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="statuc" class="col-sm-4 col-form-label">Наличие
</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticemail" readonly
name="statuc" value="${booksDelete[0].getStatuc()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="lastname" class="col-sm-4 col-form-label">Автор</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticrole" readonly
name="author" value="${booksDelete[0].getAuthor()}" />
</div>
</div>
<div class="mb-3 row">
<label for="namepublish" class="col-sm-4 col-form-label">Издательство</label>
<div class="col-sm-6">
<input type="text" class="form-control" id="staticrole" readonly
name="publish" value="${booksDelete[0].getPublish()}" />
</div>
</div>
<p>
<button type="submit" class="btn btn-primary">Удалить</button>
<a href='<c:url value="/books" />' role="button"
class="btn btn-secondary">Отменить/Возврат</a>
</p>
</form>
</div>
</article>
</section>
</div>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>