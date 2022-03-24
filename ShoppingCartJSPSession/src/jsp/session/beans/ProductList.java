package jsp.session.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
private static final List<Product>ds = new ArrayList<Product>(); 
 static{
	 
}
	public static List<Product> queryProducts() {
		return ds;
	}
	
	private static void initData() {
		Product sp = new Product();  sp.setModel("iPhone13 Pro Max");
		sp.setId("PR001");			 sp.setQuantity(10);	
		sp.setDescription("");		 sp.setImgURL("/img/dt01.jpg");
		sp.setPrice(99000);
		ds.add(sp);
		
		
		sp = new Product();  sp.setModel("Samsung Galaxy S22 Ultra");
		sp.setId("PR002");			 sp.setQuantity(10);	
		sp.setDescription("");		 sp.setImgURL("/img/dt02.jpg");
		sp.setPrice(48000);
		ds.add(sp);
		
		sp = new Product();  sp.setModel("Xiaomi 12 Pro");
		sp.setId("PR003");			 sp.setQuantity(10);	
		sp.setDescription("");		 sp.setImgURL("/img/dt03.jpg");
		sp.setPrice(52000);
		ds.add(sp);
		
		sp = new Product();  sp.setModel("Samsung Galaxy S21 FE");
		sp.setId("PR004");			 sp.setQuantity(10);	
		sp.setDescription("");		 sp.setImgURL("/img/dt04.jpg");
		sp.setPrice(52000);
		ds.add(sp);
		
		sp = new Product();  sp.setModel("Samsung Galaxy Z-Fold 3");
		sp.setId("PR005");			 sp.setQuantity(10);	
		sp.setDescription("");		 sp.setImgURL("/img/dt05.jpg");
		sp.setPrice(83000);
		ds.add(sp);
	}
}
