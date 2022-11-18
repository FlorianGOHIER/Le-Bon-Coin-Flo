<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.dao.UserDAO" %>
<%@ page import="com.jee.modele.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des utilisateurs</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body class="darksalmonfont">
		
		<h1>Voici les utilisateurs du super site LaBonneGoye !</h1>
		
		<% if( request.getAttribute("msg") != null) { %>
			<h4>${msg}</h4>
		<% } %>
		
		<table>
			<tr> <th>ID</th> <th>Login</th> <th>Adresse mail</th> <th>Mot de passe</th> <th>Prénom</th> <th>Nom de famille</th> <th>Adresse</th> </tr>
			<% for (User u: UserDAO.getAllUsers()) { %>
				<tr>
					<td class="wthin"> <%= u.getId() %></td>
					<td> <%= u.getLogin() %></td>
					<td class="wlarge"> <%= u.getMail() %></td>
					<td> <%= u.getPassword() %></td>
					<td> <%= u.getLastname() %></td>
					<td> <%= u.getFirstname() %></td>
					<td> <%= u.getAdress() %></td>
					<td> <a href="/LeBonCoin/delete?id=<%= u.getId()%> ">Supprimer</a> </td>
					<td> <a href="/LeBonCoin/modify?id=<%= u.getId()%> ">Modifier</a> </td>
					<td> <a href="/LeBonCoin/createitem?id=<%= u.getId()%> ">Mettre en ligne une annonce</a> </td>
				</tr>
			<% } %>
		</table>
		
		<div><a href='/LeBonCoin/createuser'>Ajouter un utilisateur</a></div>
		
		<div><a href='/LeBonCoin/showitem'>Voir les annonces</a></div>
		
	</body>
</html>