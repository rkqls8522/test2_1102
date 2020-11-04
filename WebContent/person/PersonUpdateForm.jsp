<%@page import="green.vo.Person"%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person data</title>
</head>
<body>
<h1>person data</h1>
<form action="update" method='post'>
번호 :<input type='text' name ='num' value= '${person.num}' readonly><br>
이름  :<input type='text' name ='name' value= '${person.name}'><br>
주민번호  :<input type='text' name ='personId' value= '${person.personId}'><br>
주소  :<input type='text' name ='juso' value= '${person.juso}'><br>
폰번호  :<input type='text' name ='phone' value= '${person.phone}'><br>
형제자매 수  :<input type='number' name ='sibling' value= '${person.sibling}'><br>
아버지 성함  :<input type='text' name ='dadName' value= '${person.dadName}'><br>
<input type='submit' value='저장'>
<input type='button' value='삭제' 
	onclick='location.href="delete?num=${person.num}";'>
<input type='button' value='취소' onclick='location.href="list"'>
</form>

</body>
</html>