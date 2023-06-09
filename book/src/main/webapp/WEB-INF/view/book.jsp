<%@ page language="java" contentType="text/html"
 pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<%@ page import="domain.Book"%>
<%@ page import="domain.Publish"%>
<%@ page import="domain.Author"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Книги</title>
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
<th scope="col">Редактировать</th>
<th scope="col">Удалить</th>
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
<td width="20"><a
href='<c:url value="/editbook?id=${book.getId()}" />'
role="button" class="btn btn-outline-primary"> <img
alt="Редактировать" src="images/edit.png" height = "30" width = "30"></a></td>
<td width="20"><a
href='<c:url value="/deletebook?id=${book.getId()}" />'
role="button" class="btn btn-outline-primary"> <img
alt="Удалить" src="images/delete.png" height = "30" width = "30"></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
<section>
<article>
<h3>Добавить книгу</h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id" class="col-sm-3 col-form-label">Id</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticLastname"
name="id" />
</div>
</div>
<div class="mb-3 row">
<label for="title" class="col-sm-3 col-form-label">Название</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticLastname"
name="title" />
</div>
</div>
<div class="mb-3 row">
<label for="code" class="col-sm-3 col-form-label">Код</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticFirstname"
name="code" />
</div>
</div>
<div class="mb-3 row">
<label for="yearpublish" class="col-sm-3 col-form-label">Год публикации</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticFirstname"
name="yearpublish" />
</div>
<div class="mb-3 row">
<label for="countpage" class="col-sm-3 col-form-label">Кол-во страниц</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticphone"
name="countpage" />
</div>
</div>
<div class="mb-3 row">
<label for="hardcover" class="col-sm-3 col-form-label">Переплёт
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="hardcover" />
</div>
</div>
<div class="mb-3 row">
<label for="abstract" class="col-sm-3 col-form-label">Реферат
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="abstract" />
</div>
</div>
<div class="mb-3 row">
<label for="statuc" class="col-sm-3 col-form-label">Наличие
</label>
<div class="col-sm-7">
<input type="text" class="form-control" id="staticemail"
name="statuc" />
</div>
</div>
<div class="mb-3 row">
<label for="lastname" class="col-sm-3 col-form-label">Автор</label>
<div class="col-sm-7">
<select name="authors" class="form-control">
<option>Выберите автора</option>
<c:forEach var="author" items="${author}">
<option value="${author}">
<c:out value="${author.getLastName()}"></c:out>
</option>
</c:forEach>
</select>
</div>
<label for="namepublish" class="col-sm-3 col-form-label">Издательство</label>
<div class="col-sm-7">
<select name="publish" class="form-control">
<option>Выберите издательство</option>
<c:forEach var="publish" items="${publishs}">
<option value="${publish}">
<c:out value="${publish.getNamePublish()}"></c:out>
</option>
</c:forEach>
</select>
</div>
<p>
<button type="submit" class="btn btn-primary">Добавить</button>
</p>
</form>
</article>
</section>
</div>
</div>
</div>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>
