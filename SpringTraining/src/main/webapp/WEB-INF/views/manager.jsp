<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매니저별 직원명단조회</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>
<body>
<h1>매니저별 직원명단조회</h1>
매니저명 : <select id=selJob>
<c:forEach items="${mem}" var="mem">
<option value="${mem.emp_id}">${mem.name}</option>
</c:forEach>
</select><br><br>
<table id=tblJob>

</table>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('change','#selJob',function(){
	let managerid=$('#selJob').val();
	$.ajax({
		url:"/train/memp",
		data:{empcode:managerid},
		method:"GET",
		datatype:"json",
		beforeSend:function(){
			$('#tblJob').empty();
		},
		success:function(data){
			for(i=0;i<data.length;i++){
				let str='<tr><td>'+data[i]['id']+'</td><td>'+
				data[i]['name']+'</td><td>'+
				data[i]['mobile']+'</td></tr>';
				$('#tblJob').append(str);
					
			}
		}
	});
})

</script>
</html>