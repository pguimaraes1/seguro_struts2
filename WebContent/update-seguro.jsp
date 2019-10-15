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
<s:form action="alteraseguro" method="post" validate="true">
	<s:textfield name="nomeSeguro" key="nomeSeguro" value="%{nomeSeguro}" size="20"></s:textfield>
	<s:textfield name="valorSeguro" key="valorSeguro" value="%{valorSeguro}" size="20"></s:textfield>
	<s:hidden name="id" value="%{id}"/>
	<s:submit method="update" key="label.cadastro" align="center"></s:submit>
	<s:submit method="#" key="label.cancelar" align="center"></s:submit>
</s:form>
</body>
</html>