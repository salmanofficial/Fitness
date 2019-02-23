package com.gms.groups.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.groups.bean.GroupBean;

@Controller
public class GroupController {

	@RequestMapping("/getCreateNewGroupForm.htm")
	String getCreateGroupForm(@ModelAttribute("GroupBean")GroupBean groupBean,BindingResult bindingResult,
			ModelMap model,HttpServletRequest request) {
		return "createNewGroupForm";
	}
}
