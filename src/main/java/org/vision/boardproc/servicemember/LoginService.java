package org.vision.boardproc.servicemember;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.*;

public class LoginService implements IService {
	private MemberDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(MemberDao.class);
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setMaxInactiveInterval(60*5);// 5분
		dao = sqlSession.getMapper(MemberDao.class);
		Member_View vo = null;
		try {
			vo = dao.select(id);
			if (vo.getId() == null) {
				System.out.println("등록된 ID가 없습니다.");
			} else {
				if ((vo.getPass()).equals(pass)) {

					if (request.getParameter("cookieSave") != null) {
						Cookie cookie = new Cookie("id", id);
						cookie.setMaxAge(60 * 60 * 24);//하루
						response.addCookie(cookie);
					}
//					model.
//					response.sendRedirect("MemberList.jsp");

				} else {
//					response.sendRedirect("CookieLogin.jsp");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}

}
