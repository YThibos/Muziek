<%@ page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>

<!DOCTYPE HTML>
<html>

<head>
	<v:head title="Welkom"/>
</head>

<body>

	<h1>Albums</h1>
	
	<dl>
	<c:forEach items="${albums}" var="album">
		<dt>
			<a href="<c:url value='albumDetail.htm?id=${album.id}'/>">${album}</a>
		</dt>
		<dd>
			${album.artiest}
		</dd>
		<br>
	</c:forEach>
	</dl>

</body>

</html>