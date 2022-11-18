package com.jee.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.ItemDAO;


@WebServlet("/deleteitem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id") );
		boolean isOk = ItemDAO.deleteItem(id);
		
		if (isOk) {
			request.setAttribute("msg", "L'annonce a bien été supprimée.");
		} else {
			request.setAttribute("msg", "Erreur dans la suppression de l'annonce.");
		}
		
		response.sendRedirect("/LeBonCoin/showitem");
	}

}
