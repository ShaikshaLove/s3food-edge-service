package io.s3soft.zuulapp.securiy.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class AuthenticationDenyHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException exception) throws IOException, ServletException {
		/*request.setAttribute("authMessage","Oye! Username and Password are incorrect!!");
		System.out.println("AuthenticationDenyHandler from");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request, response);*/
		response.sendRedirect("/login?message=Oye!! Username and Password are incorrect!!");
	}
}
