<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person add</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<h1>person add</h1>
<form action="add" method='post'>
이름  :<input type='text' name ='name'><br>
주민등록번호  :<input type='text' name ='personId'><br>
주소 :<input type='text' name ='juso'><br>
폰번호 :<input type='text' name ='phone'><br>
형제자매 수 :<input type='number' name ='sibling'><br>
아버지 성함 :<input type='text' name ='dadName'><br>
<input type='submit' value='추가'>
<input type='reset' value='취소'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>