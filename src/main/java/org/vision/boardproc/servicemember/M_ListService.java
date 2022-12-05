package org.vision.boardproc.servicemember;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.Member;
import org.vision.boardproc.model.MemberDao;

public class M_ListService implements IService {
	
	private MemberDao dao;
	SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		try {
			System.out.println("ListService 실행");
			dao = sqlSession.getMapper(MemberDao.class);
			//HashMap<String,RentMember> map = dao.selectAll();
			model.addAttribute("list",dao.selectAll());
			System.out.println("ListService 실행 end");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
