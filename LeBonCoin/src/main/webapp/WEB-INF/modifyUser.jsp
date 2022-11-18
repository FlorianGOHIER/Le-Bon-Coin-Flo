<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.dao.UserDAO" %>
<%@ page import="com.jee.modele.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Modification d'un utilisateur</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body class="darksalmonfont">
	
		<h1>Mise à jour d'utilisateur, Id = "${user.id}</h1>
	
		<% if ( request.getAttribute("msg") != null) {%>
			<h4>${msg}</h4>
		<% } %>
	
		<form method="post">
			<input type="hidden" name="txtId" value="${user.id}" >
			<br/>
			<label for="txtLogin">Login :</label>
			<input type="text" name="txtLogin" value="${user.login}">
			<br/>
			<label for="txtMail">Mail :</label>
			<input type="text" name="txtMail" value="${user.mail}">
			<br/>
			<label for="txtPassword">Password :</label>
			<input type="password" name="txtPassword" value="${user.password}">
			<br/>
			<label for='txtFirstName'>Prénom :</label>
			<input name='txtFirstName' type='text' value='${user.firstname}'/><br/>
			<br/>
			<label for='txtLastName'>Nom de famille :</label>
			<input name='txtLastName' type='text' value='${user.lastname}'/><br/>
			<br/>
			<label for='txtAdress'>Adresse :</label>
			<input name='txtAdress' type='text' value='${user.adress}'/><br/>
			<br/>
			<input type="submit">					
		</form>
	
	</body>
</html>