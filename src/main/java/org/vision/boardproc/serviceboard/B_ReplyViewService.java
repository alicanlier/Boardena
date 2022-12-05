package org.vision.boardproc.serviceboard;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.*;

public class B_ReplyViewService implements IService {

private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		//TODO 게시판폼에서 전달받은 정보를 데이타베이스에 등록 
		try {
			Map<String,Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			BoardDao dao = sqlSession.getMapper(BoardDao.class);
			//dao.upHit(num);
			
			Comment_View dto = dao.select(num);
			model.addAttribute("reply_view", dto);
			model.addAttribute("id", id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
