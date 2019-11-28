<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERRROR AL REGISTRAR</title>
</head>
	<% String msg = "El correo o el usuario ya está registrado \n Pruebe con uno diferentes \n :((("; %>
	<script>
		window.alert("El correo o el usuario ya está registrado \n Pruebe con uno diferentes \n :(((");
		window.location.href ="/sisinf/registro.html";
		</script>
</html>