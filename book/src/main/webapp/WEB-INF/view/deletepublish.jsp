<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Publish"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<head>
<meta charset="UTF-8">
<title>Удаление издательства</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список</h3>
<table class="table table-sm" id="table-info">
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
<h3>Удаление издательства</h3>
<div class="text-article">
<form method="POST" action="">
<div class="mb-3 row">
<label for="id" class="col-sm-4 col-form-label">Код издательства</label>
<div class="col-sm-6">
<input type="text" class="form-control" readonly
value="${publishsDelete[0].getId()}" />
</div>
</div>
<div class="mb-3 row">
<label for="namepublish" class="col-sm-4 col-form-label">Название</label>
<div class="col-sm-6">
<input type="text" class="form-control" name="namepublish" readonly
value="${publishsDelete[0].getNamePublish()}" />
</div>
</div>
<div class="mb-3 row">
<label for="site" class="col-sm-4 col-form-label">Сайт</label>
<div class="col-sm-6">
<input type="text" class="form-control" name="site" readonly
value="${publishsDelete[0].getSite()}" />
</div>
</div>
<div class="mb-3 row">
<label for="add" class="col-sm-4 col-form-label">Адрес</label>
<div class="col-sm-6">
<input type="text" class="form-control" name="add" readonly
value="${publishsDelete[0].getAdd()}" />
</div>
</div>
<button type="submit" class="btn btn-primary">Удалить</button>
<a href='<c:url value="/publishs" />' role="button"
class="btn btn-secondary">Отменить/Возврат</a>
</form>
</div>
</article>
<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</section>
</div>
</body>
</html>
