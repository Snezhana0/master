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
<title>Редактирование данных книги</title>
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
<th>Переплет</th>
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
<h3>Редактирование данных </h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id" class="col-sm-4 col-form-label">Id книги</label>
<div class="col-sm-7">
<input type="text" class="form-control" readonly
value="${booksEdit[0].getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="title" class="col-sm-4 col-form-label">Назвние</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticLastname"
name="title" value="${booksEdit[0].getTitle()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="code" class="col-sm-4 col-form-label">Код</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticFirstname"
name="code" value="${booksEdit[0].getCode()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="yearpublish" class="col-sm-4 col-form-label">Год публикации</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticphone"
name="yearpublish" value="${booksEdit[0].getYearpublish()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="countpage" class="col-sm-4 col-form-label">Кол-во страниц
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="countpage" value="${booksEdit[0].getCountpage()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="hardcover" class="col-sm-4 col-form-label">Переплет</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticphone"
name="hardcover" value="${booksEdit[0].getHardcover()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="abstract" class="col-sm-4 col-form-label">Реферат
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="abstract" value="${booksEdit[0].getAbstract()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="statuc" class="col-sm-4 col-form-label">Наличие
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="statuc" value="${booksEdit[0].getStatuc()}"/>
</div>
</div>
<div class="mb-3 row">
<label for="authorid" class="col-sm-4 col-form-label">Автор</label>
<div class="col-sm-7">
<select name="author" class="form-control">
<option >Выберите автора</option>
<c:forEach var="author" items="${authors}">
<option value="${author}">
<c:out value="${author.getLastName()}"></c:out>
</option>
</c:forEach>
</select>
</div>
</div>
<div class="mb-3 row">
<label for="publishid" class="col-sm-4 col-form-label">Издательство</label>
<div class="col-sm-7">
<select name="publish" class="form-control">
<option >Выберите издательство</option>
<c:forEach var="publish" items="${publishs}">
<option value="${publish}">
<c:out value="${publish.getNamePublish()}"></c:out>
</option>
</c:forEach>
</select>
</div>
</div>
<p>
<button type="submit" class="btn btn-primary">Редактировать</button>
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
