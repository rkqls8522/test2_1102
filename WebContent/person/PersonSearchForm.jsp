<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person search</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<h1>person search</h1>
<form action = "search" method="post">
	이름을 검색하세요 : <input type = "text" name="searchName"><br>
	<input type='submit' value='검색'>
	<input type='reset' value='취소'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>