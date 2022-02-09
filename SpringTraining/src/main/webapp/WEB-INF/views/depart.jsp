<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서별 직원명단조회</title>
</head>
<style>
table { border-collapse:collapse}
th,td {border:1px solid black;}
</style>
<body>
<h1>부서별 직원명단조회</h1>
부서명 : <select id=selJob>
<c:forEach items="${depart}" var="dept">
<option value="${dept.department_id}">${dept.department_name}</option>
</c:forEach>
</select><br><br>
<table id=tblJob>

</table>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('change','#selJob',function(){
	let departid=$('#selJob').val();
	$.ajax({
		url:"/train/depart1",
		data:{departcode:departid},
		method:"GET",
		datatype:"json",
		beforeSend:function(){
			$('#tblJob').empty();
		},
		success:function(data){
			for(i=0;i<data.length;i++){
				let str='<tr><td>'+data[i]['did']+'</td><td>'+
				data[i]['dname']+'</td><td>'+
				data[i]['mobile']+'</td><td>'+
				data[i]['salary']+'</td></tr>';
				$('#tblJob').append(str);
					
			}
		}
	});
})

</script>
</html>