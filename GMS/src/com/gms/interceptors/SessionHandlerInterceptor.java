package com.gms.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gms.user.service.UserService;

public class SessionHandlerInterceptor implements HandlerInterceptor {
	
	private HttpSession session = null;
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		/*UserBean userBean = new UserBean();
		userBean.setLoginId(request.getParameter("loginId"));
		userBean.setLoginPassword(request.getParameter("loginPassword"));
		
		userBean = userService.validateUser(userBean);
		if(userBean != null) {
			session = request.getSession();
			
		}*/
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
