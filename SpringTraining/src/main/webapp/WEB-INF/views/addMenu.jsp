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
<body>

 
 <table>
<tr>
	<td>
		<select id=selMenu style='width:200px;' size=10>
		<c:forEach items="${menu}" var="menu"> 
		<option value=${menu.code}>${menu.name},${menu.price}</option>
		</c:forEach>
		</select>
	</td>
	<td>
 <form action="/train/addmenu" id="frmAddMenu">
			
			<table>
			<tr><td>메뉴코드 : <input type=text id=code name=code></td></tr>
			<tr><td>메뉴명 : <input type=text name=menu_name></td></tr>
 			<tr><td>가격 : <input type=number name=price></td></tr>
 			<tr><td><input type=submit value='확인'>  <input type=button id=btnDelete value='삭제'></td></tr>
			</table>
		</form>
	</td>
</tr>
</table>
 	

</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.ready(function(){
	$.ajax({url:"/train/menulist",
		data:{},
		datatype:'json',
		method:"GET",
		success:function(txt){
			console.log(txt);
			for(i=0;i<txt.length;i++){
				let str='<option value='+txt[i]['code']+'>'+txt[i]['name']+', '+txt[i]['price']+'</option>';
				$('#selMenu').append(str);
				console.log(str);
			}
		}
		
	});
})
.on('submit','#frmAddMenu',function(){
	if($('input [name=menu_name]').val()=='' ||
		$('input [name=price]').val()==''){
		alert('두 값이 입력되어야 합니다.');
		return false;
	}
	return true;
	})
.on('click','#selMenu option',function(){
	console.log($(this).val()+','+$(this).text());
	$('#code').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
	$('input[name=menu_name]').val(ar[0]);
	$('input[name=price]').val($.trim(ar[1]));
	return false;
})
.on('click','#btnDelete',function(){
	let url="/train/deleteMenu?code="+$('#code').val();
	console.log(url);
	document.location=url;
	return false;
})

</script>
</html>