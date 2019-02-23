package com.gms.messages.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.exceptions.GMSException;
import com.gms.messages.service.MessagesService;
import com.gms.messges.bean.MessageBean;
import com.gms.user.beans.UserBean;

@Controller
public class MessagesController {
	@Autowired
	MessagesService messagesService;

	@RequestMapping(path = "/inbox.htm")
	String indox(@ModelAttribute("MessageBean")MessageBean messageBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		
		//model.addAttribute("inboxMessagesList",messagesService.inboxMails(userBean));
		return "inbox";
	}
	@RequestMapping(path = "/sendMailForm.htm")
	String sendMailForm(@ModelAttribute("MessageBean")MessageBean messageBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		return "sendMailForm";
	}
	@RequestMapping(path = "/sendMail.htm")
	String sendMail(@ModelAttribute("MessageBean")MessageBean messageBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws GMSException,Exception{

		if(bindingResult.hasErrors()){
			model.addAttribute("MessageBean", messageBean);
			return "redirect:sendMailForm.htm";
		}

		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");

		messagesService.sendMail(messageBean,userBean);


		return "redirect:inbox.htm";
	}

}
