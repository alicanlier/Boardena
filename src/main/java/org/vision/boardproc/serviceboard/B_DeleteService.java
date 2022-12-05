package org.vision.boardproc.serviceboard;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.BoardDao;

public class B_DeleteService implements IService {
	
	private BoardDao dao;
	SqlSession sqlSession = Constant.sqlSession;

	@Override
	public void execute(Model model) {
		dao = sqlSession.getMapper(BoardDao.class);
		Map<String,Object> map = model.asMap();
		int num = (Integer) map.get("num");
		
		try {
			dao.delete(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
