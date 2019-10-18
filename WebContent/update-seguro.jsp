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
	<s:textfield name="nomeSeguro" key="nomeSeguro" value="%{seguro.nome}" size="20"></s:textfield>
	<s:textfield name="valorSeguro" key="valorSeguro" value="%{seguro.valor}" size="20"></s:textfield>
	<s:hidden name="id" value="%{seguro.id}"/>
	<s:submit method="update" key="label.altualizar" align="center"></s:submit>
	<s:submit method="listaseguros" key="label.cancelar" align="center"></s:submit>
</s:form>
</body>
</html>