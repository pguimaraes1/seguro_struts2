<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="cadastra.action" validate="true">
		<s:textfield name="nomeSegurado" key="nomeSeguro" size="20"></s:textfield>
		<s:textfield name="rg" key="label.rg" size="20"></s:textfield>
				<s:textfield name="dataNascimento" key="label.bday"></s:textfield>
		<s:textfield name="cpf" key="label.cpf"></s:textfield>
		<s:radio key="label.gen" name="generos" list="generos" listKey="cod"
			listValue="descricao" value="defaultGeneroValue" />
		<s:checkboxlist key="label.seguro" list="seguros.{nome}" name="seguros"
			value="defaultSeguroValue" />
		<s:checkboxlist key="label.dia" list="dias.{dia}" name="dias"
			value="defaultDiaValue" />
					<s:select key="label.tipo" headerKey="-1"
			headerValue="-- Selecione --" list="tipos.{descricao}" name="tipos"
			value="defaultTipoValue" />
		<s:submit key="label.cadastro" align="center"></s:submit>
	</s:form>
</body>
</html>