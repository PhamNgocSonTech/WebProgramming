package tutorial.simpleweb.restfulcrud.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tutorial.simpleweb.beans.Product;
import tutorial.simpleweb.conn.SQLServerConnUtils_SQLJDBC;
import tutorial.simpleweb.utils.DBUtils;

@Path("products")//http://localhost:8080/SimpleWepApp/rest/products/
public class ProductService {
@Path("/hello")
@GET
public String hello() {
	return "Hello Baby";
}

 @Path("/all")
 @GET
 @Produces(MediaType.APPLICATION_JSON)
public List<Product> getAllProduct(){
	 List<Product>list = null;
	 Connection conn;
try {
	conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
	 list = DBUtils.queryProduct(conn);

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 return list;
 
 }
 
 @POST
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
 public void addEmployee(Product pro) {
		 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
			DBUtils.insertProduct(conn,pro);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     
 }

 // URI:
 // /contextPath/servletPath/employees
 @PUT
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
 public void updateEmployee(String pro) {
	 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
			DBUtils.findProduct(conn, pro);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
 }

 @DELETE
 @Path("/{del}")
 @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
 public void deleteEmployee(@PathParam("empNo") String empNo) {
	 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
		    DBUtils.deleteProduct(conn, empNo);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}

