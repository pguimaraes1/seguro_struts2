<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="cadastroseguro.action" method="post" validate="true">
	<s:textfield name="nomeSeguro" key="nomeSeguro" size="20"></s:textfield>
	<s:textfield name="valorSeguro" key="valorSeguro" size="20"></s:textfield>
	<s:submit method="execute" key="label.cadastro" align="center"></s:submit>
</s:form>
</body>
</html>