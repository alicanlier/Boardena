package org.vision.boardproc.serviceboard;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.*;

public class B_ModifyService implements IService {
	private SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		int num = Integer.parseInt(request.getParameter("num"));
		Comment_View vo = null;
		//Board vo2 = null;
		Board vo2 = new Board();
	
		try {
			vo = dao.select(num);
		
			String writer = request.getParameter("writer");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");

			vo2.setNum(num);
			vo2.setWriter(writer);
			vo2.setSubject(subject);
			vo2.setContent(content);
			// 
			dao.update(vo2);
			System.out.println(vo2.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
