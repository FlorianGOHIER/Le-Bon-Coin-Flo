<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.Date' %>
<%@ page import="com.jee.dao.UserDAO" %>
<%@ page import="com.jee.modele.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Création d'utilisateur</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body>
	
		<h1>Enregistrez vous sur le site de la bonne Goye :</h1>
		<h2><%= new Date() %></h2>
		<p>${error}</p>
		<form method='post'>
			<label for='txtLogin'>Login :</label>
			<input name='txtLogin' type='text' value='${login}' autofocus/><br/>
			<label for='txtEmail'>Email :</label>
			<input name='txtEmail' type='text' value='${mail}'/><br/>
			<label for='txtPassword'>Mot de passe :</label>
			<input name='txtPassword' type='password' value='${password}'/><br/>
			<label for='txtConfPassword'>Confirmation mot de passe :</label>
			<input name='txtConfPassword' type='password' value='${confPassword}'/><br/>
			<label for='txtFirstName'>Prénom :</label>
			<input name='txtFirstName' type='text' value='${firstname}'/><br/>
			<label for='txtLastName'>Nom de famille :</label>
			<input name='txtLastName' type='text' value='${lastname}'/><br/>
			<label for='txtAdress'>Adresse :</label>
			<input name='txtAdress' type='text' value='${adress}'/><br/>
			<input name='btnConnect' type='submit'/>
		</form>
	
	</body>
</html>