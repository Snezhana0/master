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
<c:forEach var="author" items="${listUser}">
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
<c:if test="${auntor == null} ">
<form method="POST" action="insert">
</c:if>
<c:if test="${author == null}">
					<input type="hidden" name="id" value="<c:out value='${author.id}' />" />
				</c:if>
<fieldset class="form-group">
					<label>Фамилия</label> <input type="text"
						value="<c:out value='${author.firstname}' />" class="form-control"
						name="name" required="required">
				</fieldset>
<fieldset class="form-group">
					<label>Имя</label> <input type="text"
						value="<c:out value='${author.lastname}' />" class="form-control"
						name="name" required="required">
				</fieldset>
</form>
<p>
<button type="submit" class="btn btn-success">Добавить</button>
</p>
</div>
</article>
</section>
</div>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>