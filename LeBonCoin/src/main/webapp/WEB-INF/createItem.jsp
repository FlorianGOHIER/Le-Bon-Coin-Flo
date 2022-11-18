<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Création d'une annonce</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body>
		
		<h1>Veuillez enregistrer votre annonce :</h1>
		<h2><%= new Date() %></h2>

		<form method='post'>
			<input name='txtUserId' type='hidden' value='${userId}' autofocus/><br/>
			<label for='txtTitle'>Titre :</label>
			<input name='txtTitle' type='text' value='${title}'/><br/>
			<label for='txtDescription'>Description :</label>
			<input name='txtDescription' type='text' value='${description}'/><br/>
			<label for='txtPrice'>Prix :</label>
			<input name='txtPrice' type='text' value='${price}'/><br/>
			<input name='btnConnect' type='submit'/>
		</form>
	
	</body>
</html>