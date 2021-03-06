package com.talmo.vim.login;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
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
	
	@ResponseBody
	@RequestMapping(value = "/doLogin")
	public String doLogin(HttpServletRequest request, ModelMap model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String result = "";
		System.out.println(email + "\n" + password);
		
		HashMap param = new HashMap();
		param.put("email", email);
		param.put("password", password);
		
		try {
			UserVO userInfo = loginService.getTalmoInfo(param);
			
			if(userInfo == null) {
				result = "fail";
			} else {
				System.out.println(userInfo);
				String nickname = userInfo.nick;
				request.getSession().setAttribute("userId", nickname);
				result = "success";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			result = "error";
		}
			
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		
		return jsonObj.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/snslogin")
	public String snslogin(@RequestBody HashMap<String, String> map, HttpServletRequest request, ModelMap model) {
		String result = "";
		String snsType = map.get("snsType");
		HttpSession session = request.getSession();
		
		try {
			if(snsType.equals("kakao")) {
				HashMap<String, Object> snsInfo = loginService.getSNSInfo(map);
				
				if(snsInfo == null) {
					result = "nomember";
					session.setAttribute("snsId", map.get("snsId"));
					session.setAttribute("snsType", map.get("snsType"));
					session.setAttribute("snsEmail", map.get("snsEmail"));
				} else {
					UserVO userInfo = loginService.getTalmoInfo(snsInfo);
					
					result = "success";
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		
		return jsonObj.toString();
	}
	
	@RequestMapping(value = "/register")
	public String registerPage(HttpServletRequest request, ModelMap model) {
		return "register";
	}
	
	@ResponseBody
	@RequestMapping(value = "/doRegister")
	public String doRegister(HttpServletRequest request, ModelMap model) {
		String result = "";
		
		HashMap param = new HashMap();
		Enumeration<String> data = request.getParameterNames();
		while(data.hasMoreElements()) {
			String key = data.nextElement();
			String value = request.getParameter(key);
			param.put(key, value);
		}
		
		try {
			int insertResult = loginService.insertTalmoMember(param);
			System.out.println(insertResult);
			result = "success";
			
		} catch (Exception e) {
			
			result = "fail";
			e.getMessage();
			e.printStackTrace();
		} 
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		
		return jsonObj.toString();

	}
	
	public void setLoginSession(HashMap param) throws Exception{
		
	}
}
