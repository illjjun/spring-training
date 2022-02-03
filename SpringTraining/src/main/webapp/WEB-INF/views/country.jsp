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
   <th>id</th><th>iso_code</th><th>name</th><th>region</th>
   </tr>
</thead>
<c:forEach items="${alcnt}" var="cnt">
<tr>
<td>${cnt.country_id}</td>
<td>${cnt.country_iso_code}</td>
<td>${cnt.country_name}</td>
<td>${cnt.country_region}</td>

</tr>
</c:forEach>
</table>
</body>
</html>