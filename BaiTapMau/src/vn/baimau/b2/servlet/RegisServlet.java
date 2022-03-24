package vn.baimau.b2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.baimau.b2.bean.UserLogin;

/**
 * Servlet implementation class RegisServlet
 */
@WebServlet("/dangki")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/bai2/registrationform.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String date = request.getParameter("date");
		String gender = null;
		if(request.getParameter("gioitinh").equals("nu")) {
			gender = "Female";
		}else {
			gender ="Male";
		}
		UserLogin user = new UserLogin();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		user.setDate(date);
		user.setGender(gender);
		request.setAttribute("user", user);
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/bai2/registrationview.jsp");
		dis.forward(request, response);
	}

}
