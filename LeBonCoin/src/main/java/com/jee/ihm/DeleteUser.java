package com.jee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UserDAO;
import com.jee.modele.User;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id") );
		boolean isOk = UserDAO.deleteUser(id);
		
		if (isOk) {
			request.setAttribute("msg", "L'utilisateur a bien été supprimé.");
		} else {
			request.setAttribute("msg", "Erreur dans la suppression de l'utilisateur.");
		}
		
		response.sendRedirect("/LeBonCoin/showuser");
		
	}
}
