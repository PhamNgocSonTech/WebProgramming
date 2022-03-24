package jsp.session.beans;

import java.util.ArrayList;

public class CartBean {
	private ArrayList<CartItemBean> alCartIteam = new ArrayList<CartItemBean>();
	private double dblOrderTotal;
	
	public int getLineItemCount() {
		
		return alCartIteam.size();
	}
	
	public CartItemBean getCartItem(int iItemIndex) {
		CartItemBean cartItem = null;
		if(alCartIteam.size() > iItemIndex) {
			cartItem = (CartItemBean) alCartIteam.get(iItemIndex);
		}
		return cartItem;	
	}
	
	
	public ArrayList<CartItemBean> getAlCartIteam() {
		return alCartIteam;
	}

	public void setAlCartIteam(ArrayList<CartItemBean> alCartIteam) {
		this.alCartIteam = alCartIteam;
	}

	public double getDblOrderTotal() {
		return dblOrderTotal;
	}

	public void setDblOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}
	
	public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity) {
		double dblUnitCost = 0.0;
		double dblTotalCost = 0.0;
		int iQuantity = 0;
		CartItemBean cartItem = new CartItemBean();
		try {
			dblUnitCost = Double.parseDouble(strUnitCost);
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setStrPartNumber(strModelNo);
				cartItem.setStrModelDescription(strDescription);
				cartItem.setDblUnitCost(dblUnitCost);
				cartItem.setiQuantity(iQuantity);
				cartItem.setDblTotalCost(dblTotalCost);
				calculatorOrderTotal();
			}
		} catch (NumberFormatException e) {
			System.out.println("Error While Parsing Form String to primitive types:"+e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public void addCartItem(CartItemBean cartItem) {
		alCartIteam.add(cartItem);
	}
	
	public void updateCartItem(String strItemIndex, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
		int iItemIndex = 0;
		CartItemBean cartItem = null;
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				cartItem = alCartIteam.get(iItemIndex - 1);
				dblUnitCost = cartItem.getDblUnitCost();
				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setiQuantity(iQuantity);
				cartItem.setDblTotalCost(dblTotalCost);
				calculatorOrderTotal();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error While Update Cart: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

	public void deleteCartItem(String strItemIndex) {
		int iItemIndex = 0;
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			alCartIteam.remove(iItemIndex-1);
			calculatorOrderTotal();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error While Delete Cart Item: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}
	
	protected void calculatorOrderTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < alCartIteam.size(); counter++) {
			CartItemBean cartItem = (CartItemBean) alCartIteam.get(counter);
			dblTotal += cartItem.getDblTotalCost();
		}
		
		setOrderTotal(dblTotal);
	}
}
