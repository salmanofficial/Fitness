package com.gms.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.common.service.CommonMasterService;
import com.gms.user.beans.UserBean;
import com.gms.user.service.UserService;

//@SessionAttributes("loginUserDtls")
@Controller
public class LoginContoller {
	
	@Autowired
	CommonMasterService commonMasterService;
	@Autowired
	UserService userService;
	
	HttpSession session = null;
	

	
	@RequestMapping(value = {"/login.htm","/"},method=RequestMethod.GET)
	String takeToLoginPage(@ModelAttribute("UserBean")UserBean userBean,ModelMap model,HttpServletRequest request) {
		session = request.getSession(false);
		if(session != null && session.getAttribute("UserName") != null && !"".equalsIgnoreCase((String)session.getAttribute("UserName")) )
			return "redirect:inbox.htm";
		return "index";
	}
	
	@RequestMapping(path = "/ValidateUser.htm")
	String validateUserAuth(@ModelAttribute("UserBean")UserBean userBean,ModelMap model,HttpServletRequest request) throws Exception {
		
		UserBean userBeanDtls = userService.validateUser(userBean);
		if(userBeanDtls != null){
			session = request.getSession();
			session.setAttribute("UserName", userBeanDtls.getFirstName() +" "+ userBeanDtls.getLastName());
			session.setAttribute("loginUserDtls", userBeanDtls);
			return "redirect:inbox.htm";
		}
		model.addAttribute("UserBean", userBean);
		return "redirect:login.htm";
		
	}
	@RequestMapping(path = "/logout.htm")
	String userLogout(@ModelAttribute("UserBean")UserBean userBean,ModelMap model,HttpServletRequest request) {
		session = request.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:login.htm";
	}
	
	@RequestMapping(path="/createNewUserform.htm")
	String takeCreateUser(@ModelAttribute("UserBean")UserBean userBean,ModelMap model ) {
		return "createNewUser";
	}
	@RequestMapping(path="/createNewUser.htm",method=RequestMethod.POST)
	String CreateUser(@Validated @ModelAttribute("UserBean")UserBean userBean,BindingResult bindingResult,ModelMap model) {
		Boolean checkForSucc = false;
		try {
			if(bindingResult.hasErrors()){
				model.addAttribute("UserBean", userBean);
				return "createNewUser";
			}
			checkForSucc = userService.createOrUpdateUser(userBean);
			if(!checkForSucc){
				model.addAttribute("UserBean", userBean);
				model.addAttribute("ErrorMessgae", "Network Failure Please Contact Admin");
				return "createNewUser";
			}
		} catch (Exception e) {
			
		}
		return "redirect:login.htm";
	}
	@ModelAttribute("allGenders")
	Map<Integer,String> getAllGenders(){
		return commonMasterService.getAllGenders();
	}
}
