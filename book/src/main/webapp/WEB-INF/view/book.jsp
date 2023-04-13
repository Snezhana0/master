<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Book"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Publish"%>
<%
Author a1 = new Author(1l, "Джон Рональд Руэл ", "Толкин");
Author a2 = new Author(2l, "Сергей ", "Довлатов");
Author a3= new Author(3l, "Кир ", " Булычёв");
Author a4 = new Author(4l, "Стефани ", "Майер");
Author[] authors = new Author[]{a1, a2, a3, a4};
pageContext.setAttribute("authors", authors);
Publish p1 = new Publish(5l, "АСТ", "ast.ru", " Москва, Звёздный бульвар, дом 21");
Publish p2 = new Publish(6l, "Азбука ", "azbooka.ru", " Москва, ул. Краснобогатырская, дом 44");
Publish p3= new Publish(7l, "Альфа-книга ", " armada.ru", " Москва, ул. Верхняя, дом 34");
Publish p4 = new Publish(8l, "Noeclassic ", "ast.ru", " Москва, Звёздный бульвар, дом 21");
Publish[] publishs = new Publish[]{p1, p2, p3, p4};
Book b1 = new Book(1l, "Властелин Колец","12", "2021", "1104","Твёрдый","Толкин, фентези, хоббит", "Есть",a1, p1,1l,5l);
Book b2 = new Book(2l, "Чемодан","13", "2016", "160","Мягкий", "Довлатов, проза, классика", "Есть", a2, p2,2l,6l);
Book b3= new Book(3l, "Сто лет тому вперёд","21", "2020", "395","Твёрдый", "Проза, фантастика" , "Нет",a3, p3,2l,7l);
Book b4 = new Book(4l, "Сумерки","31", "2021", "416", "Твёрдый", "Сумерки, вампиры, фэнтези", "Есть", a4, p4,2l,8l);
Book[] books = new Book[]{b1, b2, b3, b4};
pageContext.setAttribute("books", books);
%>
 
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
<th>Тип переплёта</th>
<th>Реферат</th>
<th>Наличие на складе</th>
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
<c:forEach var="role" items="${authors}">
<option value="${author}">
${author.getFirstName()}>
${author.getLastName()}>
</option>
</c:forEach>
</select>
</p>
<p>
<label for="publish">Издательство</label>
<select>
<option disabled>Выберите издательство</option>
<c:forEach var="role" items="${publishs}">
<option value="${publish}">
${publish.getNamePublish()}>
${publish.getSite()}>
${publish.getAdd()}>
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