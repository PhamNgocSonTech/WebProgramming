package tutorial.simpleweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tutorial.simpleweb.beans.Product;
import tutorial.simpleweb.conn.SQLServerConnUtils_SQLJDBC;
import tutorial.simpleweb.utils.DBUtils;
import tutorial.simpleweb.utils.MyUtils;

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProductServlet() {
		super();
	}

	// Hiển thị trang sửa sản phẩm.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Connection conn = MyUtils.getStoredConnection(request);
		Connection conn = null;
		Product product = null;
		String errorString = null;


		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String code = (String) request.getParameter("code");



		try {
			product = DBUtils.findProduct(conn, code);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Không có lỗi.
		// Sản phẩm không tồn tại để edit.
		// Redirect sang trang danh sách sản phẩm.
		if (errorString != null && product == null) {
			response.sendRedirect(request.getServletPath() + "/productList");
			return;
		}

		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
		dispatcher.forward(request, response);

	}

	// Sau khi người dùng sửa đổi thông tin sản phẩm, và nhấn Submit.
	// Phương thức này sẽ được thực thi.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Connection conn = MyUtils.getStoredConnection(request);
		Connection conn = null;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String code = (String) request.getParameter("code");
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			
		}
		
		
		Product product = new Product(code, name, price);
		String errorString = null;

		try {
			DBUtils.updateProduct(conn, product);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);

		// Nếu có lỗi forward sang trang edit.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(request, response);
		}
		// Nếu sửa thành công.
		// Redirect sang trang danh sách sản phẩm.
		else {
			response.sendRedirect(request.getContextPath() + "/productList");
		}
	}

}
