<%@page import="green.vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person list</title>
</head>
<body>
<jsp:include page ="/Header.jsp"/>
<h1>person list</h1>
<p><a href='add'>new person</a></p>
<p><a href='search'>person search</a></p>

<c:forEach var ="person"  items ="${persons}">
	${person.num},
	<a href='update?num=${person.num}'> ${person.name}</a>,
	${person.personId},
	${person.juso},
	${person.phone},
	${person.sibling},
	${person.dadName}
<a href='delete?num=${person.num}'>[delete]</a><br>
</c:forEach>
<jsp:include page="/Tail.jsp"/>
</body>
</html>