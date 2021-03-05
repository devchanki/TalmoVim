package com.talmo.vim.qna;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class QnaController {
	@RequestMapping(value = "/list")
	public String qnaList(HttpServletRequest request, ModelMap model) {
		return "qna";
	}
	@RequestMapping(value = "/insert")
	public String insertQnaController(HttpServletRequest request, ModelMap model) {
		return "insertQna";
	}
}
