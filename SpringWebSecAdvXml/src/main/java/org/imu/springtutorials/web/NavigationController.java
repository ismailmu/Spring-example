package org.imu.springtutorials.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

	@RequestMapping(value="/")
	public String home() {
		return "/homepage";
	}
	
	@RequestMapping(value="/homepage")
	public String homepage() {
		return home();
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="/anonymous")
	public String anonymous() {
		return "/anonymous";
	}
	
	@RequestMapping(value="/invalidSession")
	public String invalidSession() {
		return "/invalidSession";
	}
	
	@RequestMapping(value="/console")
	public String console() {
		return "/console";
	}
	
	@RequestMapping(value="/sessionExpired")
	public String sessionExpired() {
		return "/sessionExpired";
	}
}
