<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method=get action="/train/view">
<input type=text name="nickname">
<input type=submit value="send">
</form>
${mobile }
</body>
<script>
// document.location="http://localhost:8088/train/view?nickname=xxxx";
</script>
</html>