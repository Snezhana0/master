<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Publish"%>
<%
Publish p1 = new Publish(1l, "АСТ", "ast.ru", " Москва, Звёздный бульвар,дом 21");
Publish p2 = new Publish(2l, "Азбука ", "azbooka.ru", " Москва, ул. Краснобогатырская, дом 44");
Publish p3= new Publish(3l, "Альфа-книга ", " armada.ru", " Москва, ул. Верхняя, дом 34");
Publish p4 = new Publish(4l, "Noeclassic ", "ast.ru", " Москва, Звёздный бульвар, дом 21");
Publish[] publishs = new Publish[]{p1, p2, p3, p4};
int length = publishs.length;
pageContext.setAttribute("publishs", publishs);
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Издательства</title>
<head>
<meta charset="UTF-8">
<title>Publishs</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список Издательств</h3>
<table>
<thead>
<tr>
<th scope="col">Код</th>
<th scope="col">Название</th>
<th scope="col">Сайт</th>
<th scope="col">Адрес</th>
</tr>
</thead>
<tbody>
<c:forEach var="publish" items="${publishs}">
<tr>
<td>${publish.getId()}</td>
<td>${publish.getNamePublish()}</td>
<td>${publish.getSite()}</td>
<td>${publish.getAdd()}</td>
</tr>
</c:forEach>
</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Издательства</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="namerole">Издательство
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