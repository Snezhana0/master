<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Publish"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Издательства</title>
<head>
<meta charset="UTF-8">

</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список издательств</h3>
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
<h3>Данные издательства</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="id">Id</label>
<input type="text" name="id" />
</p><p>
<label for="namepublish">Название</label>
<input type="text" name="namepublish" />
</p>
<p>
<label for="site">Сайт</label>
<input type="text" name="site" />
</p>
<p>
<label for="add">Адрес</label>
<input type="text" name="add" />
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