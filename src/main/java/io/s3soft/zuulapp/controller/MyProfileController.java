package io.s3soft.zuulapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.s3soft.zuulapp.locator.UserRestClient;
import io.s3soft.zuulapp.util.NavBar;
import io.s3soft.zuulapp.util.NavbarUtil;
import io.s3soft.zuulapp.util.User;

@RestController
@RequestMapping("/myaccount")
public class MyProfileController {


	@Autowired
	private UserRestClient userRestClient;

	@GetMapping("/navbar")
	public NavBar getNavBar() {
		SecurityContext securityContext=SecurityContextHolder.getContext();
		String email=securityContext.getAuthentication().getName();
		User user=userRestClient.getUserByUserName(email);
		System.out.println(user);
		NavBar navbar=new NavBar();
		navbar.setUser(user);
		if(user.getRoles().contains("ROLE_ADMIN")) {
			navbar.setNavLinks(NavbarUtil.getAdminLinks());
		}else {
			navbar.setNavLinks(NavbarUtil.getUserLinks());
		}
		return navbar;
	}


	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username) {
		User user=userRestClient.getUserByUserName(username);
		return user;
	}
}
