package com.mountblue.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.mountblue.dao.Userdao;
import com.mountblue.model.Usermodel;

/**
 * Servlet implementation class Mountbluecontroller
 */
@WebServlet("/Mountbluecontroller")
public class Mountbluecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Userdao userdao = new Userdao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mountbluecontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		Usermodel usermodel = new Usermodel();
		usermodel.setFullname(fullname);
		usermodel.setEmail(email);
		usermodel.setMessage(message);

		try {
			userdao.registerUser(usermodel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			response.sendRedirect("Succesfulregister.jsp");
		}

	}

}
