package kr.co.seoulit.system.authorityManager.controller;


import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class MemberLogoutController {
	
    protected final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value="/logout.do", method=RequestMethod.GET)
    public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response) {
    
        HttpSession session = request.getSession();
        session.invalidate();
        logger.debug("*******OUT*****MemberLogoutController*******OUT*****");

        return new ModelAndView("loginForm");
    }
}