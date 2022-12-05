
package org.vision.boardproc.serviceboard;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.ConnFactory;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.*;

public class B_WriteService implements IService {
	private SqlSession sqlSession = Constant.sqlSession;
	private BoardDao dao;
	
	@Override
	public void execute(Model model) {
		// TODO 게시판폼에서 전달받은 정보를 데이타베이스에 등록
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String xid = (String)session.getAttribute("id");
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		dao = sqlSession.getMapper(BoardDao.class);
		Board vo = new Board();
		vo.setWriter(writer);
		vo.setSubject(subject);
		vo.setContent(content);
		try {
			dao.insert(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    CallableStatement cstmt = null;
	    ConnFactory x = new ConnFactory();
	    Connection conn = null;
	    int res = 0;
	    String sql = "select id, receivedlike, pushedlike, com_count from T_MEMBERACTIVITY";
     
	    try {
	       conn = x.getConnection();
	       pstmt = conn.prepareStatement(sql); //com_count+1
	       cstmt = conn.prepareCall("{call UPMEMACTIVITY(?,?,?,?)}");
	       rs = pstmt.executeQuery();
	       while(rs.next()) {
	    	   if (xid.equals(rs.getString("id"))) {
	    		   System.out.println("cstmt loading... in B_WriteService");
	    		   cstmt.setString(1, xid);
	    		   cstmt.setInt(2, 0);
	    		   cstmt.setInt(3, 0);
	    		   cstmt.setInt(4, 1);
	    		   cstmt.executeUpdate();
	    	   } 
	       }

	       rs.close();
	       cstmt.close();
	       pstmt.close();
	       conn.close();	    		   
	       
	    } catch (ClassNotFoundException | SQLException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
		
	}

}
