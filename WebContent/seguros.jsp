<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, br.com.phellipe.entity.Seguro"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="seguros">
				<tr>
					<td class="nowrap"><s:property value="id"/></td>
					<td class="nowarp"><s:property value="nome"/></td>
					<td><s:property value="valor"/></td>
					<td>
					<s:url action="loadseguro" var="url">
					<s:param name="id" value="id"></s:param>
					</s:url>
					<a href="<s:property value="url"/>">Editar</a>
					<s:url action="excluirseguro" var="url">
					<s:param name="id" value="id"></s:param>
					</s:url>
					<a href="<s:property value="url"/>">Excluir</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>