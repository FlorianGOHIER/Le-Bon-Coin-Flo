package com.jee.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jee.dao.UserDAO;

@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/createUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String mail = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		String confPassword = request.getParameter("txtConfPassword");
		String firstname = request.getParameter("txtFirstName");
		String lastname = request.getParameter("txtLastName");
		String adress = request.getParameter("txtAdress");
		String error = null;
		
		if (login == null || login.equals("")) {
			error = "Veuillez renseigner un login.";
		} else if (!mail.contains("@")) {
			error = "Veuillez renseigner un email valide.";
		} else if ( password.length() < 8 ) {
			error = "Le mot de passe doit contenir au moins 8 caractères.";
		} else if ( confPassword.equals(password) == false ) {
			error = "Les mots de passe doivent être identiques.";
		}
		
		if (error == null) {
			
			boolean isOk = (boolean) UserDAO.createUser(login, mail, password, firstname, lastname, adress);
			
			if (isOk) {
				request.setAttribute("msg", "Un utilisateur a été créé.");
			} else {
				request.setAttribute("msg", "Une erreur est survenue dans la création de l'utilisateur.");
			}
			
			response.sendRedirect("/LeBonCoin/showuser");
			
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("login", login);
			session.setAttribute("mail", mail);
			session.setAttribute("password", password);
			session.setAttribute("confPassword", confPassword);
			session.setAttribute("firstname", firstname);
			session.setAttribute("lastname", lastname);
			session.setAttribute("adress", adress);
			session.setAttribute("error", error);
			doGet(request, response);
		}
	
	}

}
