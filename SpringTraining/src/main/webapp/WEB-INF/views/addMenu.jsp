<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="/train/addmenu" id="frmAddMenu">
 	메뉴명 : <input type=text name=menu_name><br>
 	가격 : <input type=number name=price><br>
 	<input type=submit value='추가'>
 </form>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('submit','#frmAddMenu',function(){
	if($('input [name=menu_name]').val()=='' ||
		$('input [name=price]').val()==''){
		alert('두 값이 입력되어야 합니다.');
		return false;
	}
	return true;
	})
</script>
</html>