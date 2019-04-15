package io.s3soft.zuulapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@RequestMapping(value= {"login"},method=RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="message",required=false)String message,ModelMap map) {
		if(message!=null) {
			map.put("message", message);
		}
		return "login";
	}
	
	@RequestMapping(value="user-registration",method=RequestMethod.GET)
	public String getRegPage() {
		return "user-registration";
	}
}
