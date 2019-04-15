package io.s3soft.zuulapp.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import io.s3soft.zuulapp.securiy.handlers.AuthenticationDenyHandler;
import io.s3soft.zuulapp.securiy.handlers.CustomAccessDeniedHandler;

@EnableWebSecurity
public class S3foodSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
     private UserDetailsService userDetailsService;

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(authenticationProvider());
    }
     
     private AuthenticationProvider authenticationProvider() {
    	 DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
    		authProvider.setUserDetailsService(userDetailsService);
    		authProvider.setPasswordEncoder(passwordEncoder());
    	 
    	 return authProvider;
	}
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	 
    	 http
    	 .csrf().disable()
    	 .httpBasic()
    	 .and()
    	 .authorizeRequests()
    	 .antMatchers("/","/js/**","/css/**","/images/**","/login","/user-registration").permitAll()
    	 .antMatchers(HttpMethod.POST, "/users").permitAll()
    	 .antMatchers(HttpMethod.GET, "/users/**").permitAll()
    	 .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
    	 .antMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
    	 .antMatchers(HttpMethod.GET,"/api/products").permitAll()
    	 .antMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN")
    	 .antMatchers(HttpMethod.PUT, "/api/products").hasRole("ADMIN")
    	 .antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
    	 .anyRequest().authenticated()
    	 .and()
    	 .formLogin()
    	 .loginPage("/login")
    	 .loginProcessingUrl("/perform-login")
    	 .defaultSuccessUrl("/index.html", true)
    	 .failureHandler(authenticationFailureHandler())
    	 .and()
    	 .logout()
    	 .logoutUrl("/perform-logout")
    	 .deleteCookies("JSESSIONID")
    	 //.logoutSuccessHandler(logoutSuccessHandler())/login?message=Voila!! You are logged out successfully
    	 .logoutSuccessUrl("/")
    	 .and()
    	 .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    	 
    }

	private AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	private AuthenticationFailureHandler authenticationFailureHandler() {
		return new AuthenticationDenyHandler();
	}


	/*private LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}*/
}
