package tutorial.simpleweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
//		Connection conn = MyUtils.getStoredConnection(request);
//
//		String errorString = null;
//		List<Product> list = null;
//		try {
//			list = DBUtils.queryProduct(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			errorString = e.getMessage();
//		}
		List<Product> listProduct= null;
		//Kết nối csdl (model)
		Connection conn;
		try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
			//Model - lấy lên ds sản phẩm
			listProduct = DBUtils.queryProduct(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		//Đưa vào request
		request.setAttribute("list", listProduct);
		
//		// Lưu thông tin vào request attribute trước khi forward sang views.
//		request.setAttribute("errorString", errorString);
//		request.setAttribute("productList", list);
		
		// Forward sang /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/productListView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
