<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<head>
<meta charset="UTF-8">
<title>객실 관리</title>
</head>
<body>
<table>
<tr>
	<td>
		<select id=selRoom style='width:200px;' size=10>
		<c:forEach items="${Room}" var="rm"> 
		<option value=${rm.roomcode}>${rm.name},${rm.type},${rm.howmany},${rm.howmuch}</option>
		</c:forEach>
		</select>
	</td>
	<td>
		<form id=frmRoom action="/train/addRoom">
		
			<table>
			<tr><td align=right>객실 코드 : </td><td><input type=text id=roomcode name=roomcode></td></tr>
			<tr><td align=right>객실명:</td>
				<td><input type=text name=roomname></td>
			</tr>
			<tr><td align=right>타입:</td>
				<td>
				<select id=roomtype name=roomtype>
				<option>-</option>
				<c:forEach items='${roomtype}' var='roomtype'>
					<option value="${roomtype.typecode}">${roomtype.name}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr><td align=right>숙박가능인원:</td>
				<td><input type=number name=howmany></td>
			</tr>
			<tr><td align=right>숙박비:</td>
				<td><input type=number name=howmuch></td>
			</tr>
			<tr><td colspan=2 align=center>
				<input type=submit value='확인'>
				<input type=reset value='초기화'>
				<input type=button value='삭제' id=btnDelete></td>
			</tr>
			</table>
		</form>
	</td>
</tr>
</table>
</body>

<script>
$(document)
.on('click','#selRoom option',function(){
	console.log($(this).val()+','+$(this).text());
	$('#roomcode').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
	$('input[name=roomname]').val(ar[0]);
	let roomtype=$.trim(ar[1]);
	$('input[name=howmany]').val(ar[2]);
	$('input[name=howmuch]').val(ar[3]);
	$('#roomtype').val('');
	$('#roomtype option').each(function(){
		if($(this).text()==roomtype){
			$(this).prop('selected',true);
			return false;
		}
	})	
	
	return false;
})
.on('click','#btnDelete',function(){
	let url="/train/deleteRoom?roomcode="+$('#roomcode').val();
	console.log(url);
	document.location=url;
	return false;
})
</script>
</html>