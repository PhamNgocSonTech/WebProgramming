package tutorial.simpleweb.restfulcrud.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
@Path("/hello")//http://localhost:8080/SimpleWepApp/rest/products/hello
@GET
public String hello() {
	return "Hello Baby";
}
@Path("/json")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String demoJsonHello() {
    return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
}
 @Path("/all")//http://localhost:8080/SimpleWepApp/rest/products/all
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
 @Path("/add")
 @Produces(MediaType.APPLICATION_JSON)
 public void addProduct(Product pro) {
		 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
			DBUtils.insertProduct(conn,pro);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     
 }

 
 @PUT
 @Path("/edit")
 @Produces(MediaType.APPLICATION_JSON)
 public void updateProduct(Product pro) {
	 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
			DBUtils.updateProduct(conn, pro);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
 }

 @DELETE
 @Path("/{del}")
 @Produces(MediaType.APPLICATION_JSON)
 public void deleteProduct(@PathParam("code") String code) {
	 Connection conn;
	 try {
			conn = SQLServerConnUtils_SQLJDBC.getSQLServerConnUtils_SQLJDBC();
		    DBUtils.deleteProduct(conn, code);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}

