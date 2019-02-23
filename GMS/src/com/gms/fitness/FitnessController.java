package com.gms.fitness;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gms.messages.service.MessagesService;
import com.gms.user.beans.UserBean;

@Controller
public class FitnessController {
	@Autowired
	FitnessDaoImp fitnessDao;
	@Autowired
	MessagesService messagesService;

	@RequestMapping(value = "/createEvent",method=RequestMethod.GET)
	String createEvent(@ModelAttribute("FitnessBean")FitnessBean fitnessBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) {
		model.addAttribute("allCoachesNames", getAllGenders());
		return "addEvent";
	}
	
	@RequestMapping(value = "/addEvent",method=RequestMethod.POST)
	String addEvent(@ModelAttribute("FitnessBean")FitnessBean fitnessBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		
		
		fitnessDao.addEvent(fitnessBean, userBean);
		
		return "redirect:inbox.htm";
	}
	
	@RequestMapping(value = "/viewAllEvents",method=RequestMethod.GET)
	String viewAllEvents(@ModelAttribute("FitnessBean")FitnessBean fitnessBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		
		
		model.addAttribute("allCoachesNames", getAllGenders());
		model.addAttribute("inboxMessagesList",messagesService.inboxMails(userBean,false));
		return "viewEvent";
	}
	@RequestMapping(value = "/requestEvents",method=RequestMethod.GET)
	String requestEvents(@ModelAttribute("FitnessBean")FitnessBean fitnessBean,ModelMap model,
			BindingResult bindingResult,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		
		model.addAttribute("requestFalg","Y");
		model.addAttribute("inboxMessagesList",messagesService.inboxMails(userBean,true));
		return "viewEvent";
	}
	@RequestMapping(value = "/inviteToEvent",method=RequestMethod.GET)
	String inviteToEvent(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		UserBean userBean = (UserBean) session.getAttribute("loginUserDtls");
		if(userBean == null)
			throw new Exception("Please Login Once Again");
		
		
		String userId = request.getParameter("userId");
		String msgId = request.getParameter("msgId");
		
		fitnessDao.inviteTOEvent(msgId, userId, userBean);
		
		return "redirect:inbox.htm";
	}
	
	
	//@ModelAttribute("allCoachesNames")
	Map<Integer,String> getAllGenders(){
		return fitnessDao.getAllCoaches();
	}
}
