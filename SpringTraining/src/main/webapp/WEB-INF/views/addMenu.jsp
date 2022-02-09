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
		</select>
	</td>
	<td>
<!--  <form action="/train/addmenu" id="frmAddMenu"> -->
			
			<table>
			<tr><td>메뉴코드 : <input type=text id=code name=code></td></tr>
			<tr><td>메뉴명 : <input type=text name=menu_name id=menu_name></td></tr>
 			<tr><td>가격 : <input type=number name=price id=price></td></tr>
 			<tr><td><input type=button value='확인' id=btnAdd>  <input type=button id=btnDelete value='삭제'></td></tr>
			</table>
<!-- 		</form> -->
	</td>
</tr>
</table>
 	

</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.ready(function(){
	loadMenu();
})
.on('click','#btnAdd',function(){
	   $.ajax({
		      url:"/train/addmenu",
		      data:{code:$('#code').val(),
		      menu_name:$('#menu_name').val(),
		      price:$('#price').val()},
		      method:"GET",
		      datatype:'json',
		      beforeSend:function(){alert('ㅋㅋ')},
		      success:function(data){
		    	  loadMenu();
		      }
		   });
	return false;
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
});

function loadMenu(){
	$('#code,#menu_name,#price').val('');
	$.ajax({ url:"/train/menulist",
	data: {},
	method:"GET",
	datatype:"json",
	success:function(txt){   //model로 받아오는걸 ajax호출로 하는거임
	$('#selMenu').empty();
	for(i=0; i<txt.length; i++){
		let str='<option value='+txt[i]['code']+'>'+txt[i]['name']+', '+txt[i]['price']+'</option>';
		console.log(str);
		$('#selMenu').append(str);
		}
	}
		});
		}
</script>
</html>