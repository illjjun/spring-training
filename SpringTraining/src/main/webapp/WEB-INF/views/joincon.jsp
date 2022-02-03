<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table{border-collapse:collapse;}
th,td{border:1px solid black;}
</style>
<body>
<table>
<thead>
   <tr>
   <th>부서아이디</th><th>부서명</th><th>상위부서명</th><th>부서장이름</th>
   </tr>
</thead>
<c:forEach items="${aljc}" var="jc">
<tr>
<td>${jc.de_id}</td>
<td>${jc.de_name}</td>
<td>${jc.upde_na}</td>
<td>${jc.manager_name}</td>

</tr>
</c:forEach>
</table>
</body>
</html>