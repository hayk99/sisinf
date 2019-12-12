<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MAL PUBLICADO</title>
</head>
	<% String msg = (String)request.getAttribute("error"); %>
	<script>
		window.alert("<%=msg%>");
		window.location.href ="/sisinf/foro.jsp";
		</script>
</html>