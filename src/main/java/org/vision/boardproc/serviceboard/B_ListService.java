package org.vision.boardproc.serviceboard;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.BoardDao;

public class B_ListService implements IService {
	private BoardDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(BoardDao.class);
		try {
			model.addAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
