package com.talmo.vim.login;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		request.getSession().invalidate();
		model.addAttribute("result", "logout success");
		
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage(HttpServletRequest request, ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/doLogin")
	public String doLogin(HttpServletRequest request, ModelMap model) {
		
		
		return "index";
	}
	
	@RequestMapping(value = "/register")
	public String registerPage(HttpServletRequest request, ModelMap model) {
		return "register";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/kakao")
	public String kakaoLogin(@RequestBody Map<String, String> bodyObject, HttpServletRequest request, 
			HttpServletResponse response, ModelMap model) {
		Map<String, String> param = bodyObject;		
		
		JsonObject obj = new JsonObject();
		
		request.getSession().setAttribute("nickname", param.get("nick"));
		
		obj.addProperty("result", "success");
		obj.addProperty("user", param.get("nick"));
		
		return obj.toString();
	}
}
