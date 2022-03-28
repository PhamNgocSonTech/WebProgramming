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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tutorial.simpleweb.beans.Product;
import tutorial.simpleweb.conn.SQLServerConnUtils_SQLJDBC;
import tutorial.simpleweb.utils.DBUtils;
import tutorial.simpleweb.utils.MyUtils;

@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateProductServlet() {
		super();
	}

	// Hiển thị trang tạo sản phẩm.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//Kèm theo dữ liệu
		Product product = new Product();
		request.setAttribute("product", product);
		//chuyển tiếp sang trang createProductView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
		dispatcher.forward(request, response);
	}

	// Khi người dùng nhập các thông tin sản phẩm, và nhấn Submit.
	// Phương thức này sẽ được gọi.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Connection conn = MyUtils.getStoredConnection(request);
		Connection conn = null;
		try {
			conn=SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
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
		
		//xử lý lưu 
		Product product = new Product(code, name, price);

		
		
		String errorString = null;
		if (errorString == null) {
			try {
				//DBUtils.insertProduct(conn, product);
				Client client = ClientBuilder.newClient();
				WebTarget webTarget = client.target("http://localhost:8080/DemoRest/rest/")
									.path("products/add");
				Invocation.Builder invoBuilder= webTarget
						.request(MediaType.APPLICATION_JSON);
				Response res = invoBuilder.post(Entity.entity(product, MediaType.APPLICATION_JSON));
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
//
//
		// Mã sản phẩm phải là chuỗi chữ [a-zA-Z_0-9]
		// Có ít nhất một ký tự.
		String regex = "\\w+";
		
		//nếu mã rỗng hoặc mã không khớp vs biểu thức matches
		if (code == null || !code.matches(regex)) {
			errorString = "Product Code invalid!";
		}
//
		
//
//		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
//
		// Nếu có lỗi forward (chuyển tiếp) sang trang 'edit'.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}
		// Nếu thêm thành công.
		// Redirect (chuyển hướng) sang trang danh sách sản phẩm.
		else {
			//Ko kèm dữ liệu
			response.sendRedirect(request.getContextPath() + "/productList");
		}
	}

}
