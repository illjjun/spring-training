<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method=get action="/train/incalc">

<h1>Input.jsp</h1>
첫번째값 : <input type=text name="x1"><br>
두번째값 : <input type=text name="x2"><br>
op : <input type=text name="op"><br>
<input type=submit value="보내기"><br>
<c:if test="${result==null}">
	<h2>값없음</h2>
</c:if>
<c:if test="${result!=null}">
	<h2>${result}</h2>
</c:if>



</form>
</body>
</html>