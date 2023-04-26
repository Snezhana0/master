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
<c:forEach var="publish" items="${listPublish}">
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
<c:if test="${publish == null} ">
<form method="POST" action="insert">
</c:if>
<c:if test="${publish == null}">
					<input type="hidden" name="id" value="<c:out value='${author.id}' />" />
				</c:if>
<fieldset class="form-group">
					<label>Название</label> <input type="text"
						value="<c:out value='${publish.namepublish}' />" class="form-control"
						name="name" required="required">
				</fieldset>
<fieldset class="form-group">
					<label>Сайт</label> <input type="text"
						value="<c:out value='${publish.site}' />" class="form-control"
						name="name" required="required">
				</fieldset>
<fieldset class="form-group">
					<label>Адрес</label> <input type="text"
						value="<c:out value='${publish.add}' />" class="form-control"
						name="name" required="required">
				</fieldset>
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