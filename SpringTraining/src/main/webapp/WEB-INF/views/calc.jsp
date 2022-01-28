<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>calc.jsp</h1>
<br>
       곱셈결과 : <input type=text value=${result } readonly>
</body>
<script src='https://code.jquery.com/jquery-3.5.0'></script>
<script>
alert(${result});
</script>
</html>