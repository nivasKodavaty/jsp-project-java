package com.mountblue.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mountblue.dao.Admindao;
import com.mountblue.model.*;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Admindao admindao = new Admindao();
	private static final String ADMIN = "admin";
	private static final String PASSWORD = "0000";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Adminlogincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean flag = true;
	
		if (flag) {
			List<Usermodel> userList = new ArrayList<>();
			List<Usermodel> archievedUserList = new ArrayList<>();

			try {
				userList = admindao.getActiveUsers();
				archievedUserList = admindao.getArchievedUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("userList", userList);
			request.setAttribute("archievedUserList", archievedUserList);
			request.getRequestDispatcher("/Adminloginsuccesful.jsp").forward(request, response);

		} else {
			System.out.println(false);
			request.getRequestDispatcher("adminloginfail.html").forward(request, response);
			;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("true");
		int id = Integer.parseInt(request.getParameter("requestId"));
		String action = request.getParameter("action");
		System.out.print(action +id);
		if (action.equals("active")) {
			try {
				admindao.updateUserActive(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				admindao.updateUserArchieve(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		doGet(request,response);
		
	}

}
