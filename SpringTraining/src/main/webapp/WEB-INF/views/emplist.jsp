<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
<th>사번</th><th>이름</th><th>전화번호</th><th>매니저아이디</th><th>입사일자</th>
</tr>
</thead>
<tbody id=tblEmp>

</tbody>
<tfoot>
<tr><td colspan=5>
<input type=text id=txtKeyWord><input type=button value=직원명단 id=btnShow>
</td></tr>
</tfoot>
</table>
</body>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
$(document)
.on('click','#btnShow',function(){
	$.ajax({url:"/train/emplist",
		data:{kw:$('#txtKeyWord').val()},
		datatype:'json',
		method:"GET",
		beforeSend:function(){
			$('#tblEmp').empty();
		},
		success:function(txt){
			for(i=0;i<txt.length;i++){
				let str='<tr><td>'+txt[i]['id']+'</td><td>'+txt[i]['name']+'</td><td>'+
				txt[i]['mobile']+'</td><td>'+txt[i]['manager']+'</td><td>'+txt[i]['hire']+'</td></tr>'
				$('#tblEmp').append(str);
			}
		}
		
	});
	return false;
})

</script>
</html>