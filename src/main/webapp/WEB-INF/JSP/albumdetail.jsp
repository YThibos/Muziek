<%@ page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>

<!DOCTYPE HTML>
<html>

<head>
	<v:head title="Album details"/>
</head>

<body>
	<h1>"${album}" - ${album.artiest}</h1>
	
	<dl>
		<c:forEach items="${album.tracks}" var="track">
			<dt>${track.naam}</dt>
			<dd>${track.speeltijd}</dd>
		</c:forEach>
	</dl>
	
	Totale speeltijd: ${album.totaleSpeeltijd }

</body>

</html>