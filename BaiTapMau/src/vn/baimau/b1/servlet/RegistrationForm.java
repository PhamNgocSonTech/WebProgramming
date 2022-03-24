package vn.baimau.b1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.baimau.b1.bean.Student;
@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/bai1/dangkiform.jsp");
		rd.forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter dt = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String date = request.getParameter("date");
		String email = request.getParameter("email");
		String mobileNum = request.getParameter("mobileNum");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pinCode = request.getParameter("pinCode");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String hobbies = request.getParameter("ck");
		String course = request.getParameter("course");
		String gender = null;
		if(request.getParameter("gioitinh").equals("nu")) {
			gender = "Female";
		}else {
			gender ="Male";
		}
		Student sv = new Student();
		sv.setFname(fname);
		sv.setLname(lname);
		sv.setAddress(address);
		sv.setEmail(email);
		sv.setGender(gender);
		sv.setHobbies(hobbies);
		sv.setBirthday(date);
		
		request.setAttribute("student", sv);
		//Chuyển tiếp tới jsp show kết quả
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/bai1/resultform.jsp");
		rd.forward(request, response);

	}
}
