package com.talmo.vim.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupService service;

	public String createGroupPage() {
		return "";
	}
	
	public String inviteGroupPage() {
		return "";
	}

	@GetMapping("/detail/{group_id}")
	public String groupDetailPage(@PathVariable(name = "group_id") Long groupId, HttpSession session) {
		session.setAttribute("group", service.findGroup(groupId));
		return "group-detail";
	}
	
	public String groupSettingPage() {
		return "";
	}
}
