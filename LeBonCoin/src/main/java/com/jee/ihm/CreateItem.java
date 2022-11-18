package com.jee.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jee.dao.ItemDAO;

@WebServlet("/createitem")
public class CreateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt( request.getParameter("id") );
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		request.getRequestDispatcher("/WEB-INF/createItem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt( request.getParameter("txtUserId"));
		String title = request.getParameter("txtTitle");
		String description = request.getParameter("txtDescription");
		float price = Float.valueOf(request.getParameter("txtPrice")); 
		
		String error = null;
			
		boolean isOk = (boolean) ItemDAO.createItem(userId, title, description, price);
			
		if (isOk) {
			request.setAttribute("msg", "Un utilisateur a été créé.");
		} else {
			request.setAttribute("msg", "Une erreur est survenue dans la création de l'utilisateur.");
		}
			
		response.sendRedirect("/LeBonCoin/showuser");
			

		
	}
}
