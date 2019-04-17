package io.s3soft.zuulapp.util;

import java.util.ArrayList;

public class NavbarUtil {

	public static ArrayList<NavLink>  getAdminLinks(){
		ArrayList<NavLink> al=new ArrayList<>();
			
		al.add(new NavLink("Home", "/#/home"));
		al.add(new NavLink("Sell A Product", "/#/product-register"));
		al.add(new NavLink("S3food Product Details", "/#/product-manipulation"));
		al.add(new NavLink("S3food User Details", "/#/user-data"));
		al.add(new NavLink("My Profile", "/#/my-profile"));

		al.add(new NavLink("Logout", "/perform-logout"));
		
		return al;
	}
	public static ArrayList<NavLink> getUserLinks(){
		ArrayList<NavLink> al=new ArrayList<>();
		al.add(new NavLink("Home", "/#/home"));
		al.add(new NavLink("Fast food", "/#/products"));
		al.add(new NavLink("Biryani", "/#/products"));
		/*
		 * al.add(new NavLink("Breakfast", "/#/products")); al.add(new NavLink("Lunch",
		 * "/#/MyCart"));
		 */
		al.add(new NavLink("Snacks", "/#/products"));
		al.add(new NavLink("My Profile", "/#/my-profile"));
		al.add(new NavLink("My Cart", "/#/MyCart"));
		al.add(new NavLink("Logout", "/perform-logout"));
		return al;
	}
	
}
