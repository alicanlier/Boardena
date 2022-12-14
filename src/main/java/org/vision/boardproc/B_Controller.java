package org.vision.boardproc;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.Board;
import org.vision.boardproc.model.BoardDao;
import org.vision.boardproc.model.Comment_View;
import org.vision.boardproc.serviceboard.B_ContentService;
import org.vision.boardproc.serviceboard.B_DeleteService;
import org.vision.boardproc.serviceboard.B_LikeCountService;
import org.vision.boardproc.serviceboard.B_ListService;
import org.vision.boardproc.serviceboard.B_ModifyService;
import org.vision.boardproc.serviceboard.B_ReplyService;
import org.vision.boardproc.serviceboard.B_ReplyViewService;
import org.vision.boardproc.serviceboard.B_WriteService;


@Controller
@RequestMapping("/board/*")
public class B_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(B_Controller.class);
	IService service;
	BoardDao dao;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
		dao = sqlSession.getMapper(BoardDao.class);
	}
	
	
	@RequestMapping("/reply")
	public String reply(Model model,HttpServletRequest request) {
		System.out.println("reply()");
		model.addAttribute("request", request);
		service = new B_ReplyService();
		service.execute(model);
			
		return "redirect:list";
	}


	@RequestMapping("/reply_write")
	public String reply_view(Model model,HttpServletRequest request) {
		System.out.println("reply_write() ??????");
		model.addAttribute("request", request);
		service = new B_ReplyViewService();
		service.execute(model);
		return "/board/reply_write";
	}
	
//	@RequestMapping("/like_count")
//	public String like_count(Model model,HttpServletRequest request) {
//		System.out.println("like_count() ??????");
//		model.addAttribute("request", request);
//		service = new B_LikeCountService();
//		service.execute(model);
//		return "/board/board_content_view";
//	}
	
//	@RequestMapping("/hit_count")
//	public void hit_count(Model model,HttpServletRequest request) {
//		System.out.println("hit_count() ??????");
//		model.addAttribute("request", request);
//		model.addAttribute("hit",true);
//		service = new B_LikeCountService();
//		service.execute(model);
//		return "/board/board_content_view";
//	}	
	
	@RequestMapping("/modify")
	public String modify(Model model,HttpServletRequest request) {
		System.out.println("modify url execute start");
		String memid="";
//		try {
			HttpSession session = request.getSession();
			memid=(String) session.getAttribute("id");
			if(memid==null) {
				System.out.println("modify url executing");
				return "/member/loginForm";
			}
			System.out.println("board modify() ??????");
			
			model.addAttribute("request", request);
			model.addAttribute("memid",memid);
			service = new B_ModifyService();
			service.execute(model);
			
		System.out.println("modify url executed");
		return "redirect:list";
	}
	
	
	@RequestMapping(value ="/board_content_view", method = RequestMethod.GET)
	public String content_view(Model model,HttpServletRequest request) {
		System.out.println("board_content_view url ??????");
		model.addAttribute("request", request);
		service = new B_ContentService();
		service.execute(model);
		return "/board/board_content_view";
	}
	
	
	
	
	@RequestMapping("/boardwrite")
	public String write(Model model,HttpServletRequest request) 
			throws SQLException, IOException {
		System.out.println("boardwrite() ??????");
		model.addAttribute("request", request);
		service = new B_WriteService();
		service.execute(model);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/write_view")
	public String write_view(HttpServletRequest request,Model model) {
		
		String memid="";
		HttpSession session = request.getSession();
		memid=(String) session.getAttribute("id");
		if(memid==null) {
			return "/member/loginForm";
		}
		System.out.println("write_view()??? ???????????????.");
		model.addAttribute("id",memid);

		return "/board/write_view";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model) {
//	public String list(Model model) {
//		service = new B_ListService();
//		service.execute(model);
//		model.addAttribute("message","?????? ?????? ????????????.!");
//		return "/board/boardlist";
		// ???????????? ???????????? ?????? ?????? ??????????????????.
//		HttpSession session = request.getSession();
//		String memid = (String) session.getAttribute("id");
		try {
//			model.addAttribute("id",memid);
			System.out.println("B_Controller/list executed...");
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list url executed");
		return "/board/boardlist";
	}

	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Model model,HttpServletRequest request) {
		// ???????????? ???????????? ?????? ?????? ????????? ??? 
		System.out.println("board/delete() ??????");
		service = new B_DeleteService();
		int num = Integer.parseInt(request.getParameter("num"));
		model.addAttribute("num", num);
		service.execute(model);
	
		return "redirect:list";
	
	}
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("????????? ?????? ?????????.! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message","????????? ?????? ????????????.!");
		return "home";
	}
	
	
	
}
