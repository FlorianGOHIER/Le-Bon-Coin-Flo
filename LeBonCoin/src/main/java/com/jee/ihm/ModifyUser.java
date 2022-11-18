package com.jee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UserDAO;
import com.jee.modele.User;

@WebServlet("/modify")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt( request.getParameter("id") );
		User u = UserDAO.getOneUser(id);
		
		if (u != null) {
			request.setAttribute("user", u);
			request.getRequestDispatcher("/WEB-INF/modifyUser.jsp").forward(request, response);
		} else {
			response.sendRedirect("/LeBonCoin/showuser");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt( request.getParameter("txtId") );
		String login = request.getParameter("txtLogin");
		String mail = request.getParameter("txtMail");
		String password = request.getParameter("txtPassword");
		String firstname = request.getParameter("txtFirstName");
		String lastname = request.getParameter("txtLastName");
		String adress = request.getParameter("txtAdress");
		
		boolean isOK = UserDAO.updateUser(id, login, mail, password, firstname, lastname, adress);
		
		if (isOK) {
			request.setAttribute("msg", "Modifié avec succes");
			response.sendRedirect("/LeBonCoin/showuser");
		} else {
			request.setAttribute("msg", "Problème dans la modification");
			doGet(request, response);
		}
		
	}

}
