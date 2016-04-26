<%@ page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
	<title>Welkom</title>
</head>

<body>

	<h1>Albums</h1>
	
	<ul>
	<c:forEach items="${albums}" var="album">
		<li><a href="<c:url value='albumDetail?id=${album.id}'/>">${album}</a></li>
	</c:forEach>
	</ul>

</body>

</html>