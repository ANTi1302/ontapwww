package com.iuh.ontap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login-form";
	}
	@GetMapping("/logout")
	public String logout(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userPrincipal");
		return "redirect:/logout";
	}
}
