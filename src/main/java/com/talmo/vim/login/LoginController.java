package com.talmo.vim.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(value = "/page")
	public String loginPage(HttpServletRequest request, ModelMap model) {
		return "login";
	}
}
