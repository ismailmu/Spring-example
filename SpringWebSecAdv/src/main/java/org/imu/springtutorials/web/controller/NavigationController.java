package org.imu.springtutorials.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {
	
	@RequestMapping(value="/")
	public String home() {
		return "welcome";
	}
	@RequestMapping(value="welcome")
	public String homepage() {
		return home();
	}
	
	@RequestMapping(value="admin")
	public String console() {
		return "admin";
	}
}