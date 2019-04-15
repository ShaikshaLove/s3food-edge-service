package io.s3soft.zuulapp.securiy.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		super.onLogoutSuccess(request, response, authentication);
	
	/*	System.out.println("CustomLogoutSuccessHandler from");
		request.setAttribute("logoutMessage","Oye!! You are logged out successfully");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request, response);*/
		response.sendRedirect("/login?message=Voila!! You are logged out successfully");

	}
	
	
}
