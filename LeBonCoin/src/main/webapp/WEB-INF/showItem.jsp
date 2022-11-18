<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.dao.ItemDAO" %>
<%@ page import="com.jee.modele.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des annonces</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body class="darkgreen">

		<h1>Voici les annonces mises en lignes sur LaBonneGoye !</h1>
		
		<% if( request.getAttribute("msg") != null) { %>
			<h4>${msg}</h4>
		<% } %>
		
		<table>
			<tr> <th>ID</th> <th>ID du vendeur</th> <th>Titre</th> <th>Description</th> <th>Prix</th> <th>Date de mise en ligne</th> <th>Date de dernière modification</th> </tr>
			<% for (Item i: ItemDAO.getAllItems()) { %>
				<tr>
					<td> <%= i.getId() %></td>
					<td> <%= i.getUserId() %></td>
					<td> <%= i.getTitle() %></td>
					<td> <%= i.getDescription() %></td>
					<td> <%= i.getPrice() %></td>
					<td> <%= i.getDateCreation() %></td>
					<td> <%= i.getDateModification() %></td>
					<td> <a href="/LeBonCoin/deleteitem?id=<%= i.getId()%> ">Supprimer</a> </td>
					<td> <a href="/LeBonCoin/modifyitem?id=<%= i.getId()%> ">Mettre à jour</a> </td>
					<td> <a href="/LeBonCoin/pageitem?id=<%= i.getId()%> ">Page de l'annonce</a> </td>
				</tr>
			<% } %>
		</table>
		
		<div><a href='/LeBonCoin/showuser'>Voir les utilisateurs</a></div>
		
	</body>
</html>