<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login JAAS</title>
	</head>
	<body>
		<div align="center">
			<form action="j_security_check" method="post">
				Username:<input type="text" name="j_username" value="" />
				<br/>
				Password:<input type="password" name="j_password" value="" />
				<br/>
				<input type="submit" value= "Login" />
				
				<% if (request.getUserPrincipal()!=null){%>
        <logic:redirect href="/ConsRetencionesWeb/consulta/ConsultaController.jpf" />
    <%}%>
			</form>
		</div>
		
	</body>
	
</html>