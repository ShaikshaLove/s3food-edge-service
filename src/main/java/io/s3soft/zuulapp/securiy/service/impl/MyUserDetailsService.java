package io.s3soft.zuulapp.securiy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.s3soft.zuulapp.locator.UserRestClient;
import io.s3soft.zuulapp.util.User;

/**
 * @author shaiksha
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
	
	
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("---> From ladUserByUserName()");
		User user=userRestClient.getUserByUserName(email);
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;

		if (user == null) {
			throw new UsernameNotFoundException(
					"No user found with username: "+ email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail().toLowerCase(),
				user.getPassword(),
				user.isEnabled(), 
				accountNonExpired, 
				credentialsNonExpired,
				accountNonLocked, 
				getAuthorities(user.getRoles())
				);
	}

	 private static List<GrantedAuthority> getAuthorities (List<String> roles) {
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        for (String role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role));
	        }
	        return authorities;
	    }

	
	}
