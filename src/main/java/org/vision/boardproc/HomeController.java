package org.vision.boardproc;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.servicemember.LoginService;
@Controller
public class HomeController {
//public class HomeController extends HttpServlet implements RequestDispatcher {	
	
	
//	@Override
//	public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,Model model,HttpServletRequest request) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("request", request);
		return "home";
	}
	
}
