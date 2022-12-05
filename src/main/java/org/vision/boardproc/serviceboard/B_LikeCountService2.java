package org.vision.boardproc.serviceboard;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.common.ConnFactory;
import org.vision.boardproc.common.Constant;
import org.vision.boardproc.common.IService;
import org.vision.boardproc.model.*;

public class B_LikeCountService2 implements IService {

	private BoardDao dao;
	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		// TODO 목록의 제목을 클릭했을 때 보여줄 상세내용을 위한 서비스 
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		int xnum = Integer.parseInt(request.getParameter("num"));
		String xid = (String)session.getAttribute("id");
		String writer = null;
		System.out.println("B_LikeService is executed.");

		dao = sqlSession.getMapper(BoardDao.class);
		try {
			Comment_View dto = dao.select(xnum);
			writer = dto.getWriter();
			model.addAttribute("content",dto);
			model.addAttribute("request",request);
			session.setAttribute("isLiked",true);
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
	    String sql1 = "select num, memid from T_WHOLIKEDLOG";
	    String sql2 = "select num, hit, liked from t_commenthitlike";
	    String sql3 = "select id, receivedlike, pushedlike, com_count from T_MEMBERACTIVITY";
	    String sql4 = "insert into T_WHOLIKEDLOG(num, memid) values(?,?)";
	    
	    
      
	    try {
	       conn = x.getConnection();
//	       pstmt = conn.prepareStatement(sql1);
//	       rs = pstmt.executeQuery();
//	       while(rs.next()) {
//	    	   if (rs.getInt("num")==xnum && (rs.getString("memid")).equals(xid)) {
//	    		   return;
//	    	   } else {
			       pstmt = conn.prepareStatement(sql2);
			       cstmt = conn.prepareCall("{call uphitlike(?,?,?)}");
			       rs = pstmt.executeQuery();
			       while(rs.next()) {
			    	   if (xnum == rs.getInt("num")) {
			    		   cstmt.setInt(1, xnum);
			    		   cstmt.setInt(2, 0);
			    		   cstmt.setInt(3, 1); //like +1
			    		   cstmt.executeUpdate();
			    	   }
			       }
			       
			       pstmt = conn.prepareStatement(sql3); //pushedlike+1 & receivedlike+1
			       cstmt = conn.prepareCall("{call UPMEMACTIVITY(?,?,?,?)}");
			       rs = pstmt.executeQuery();
			       while(rs.next()) {
			    	   if (xid.equals(rs.getString("id"))) { //pushedlike+1 
			    		   cstmt.setString(1, xid);
			    		   cstmt.setInt(2, 0);
			    		   cstmt.setInt(3, 1);
			    		   cstmt.setInt(4, 0);
			    		   cstmt.executeUpdate();
			    	   } else if (writer != null && writer.equals(rs.getString("id"))) { //receivedlike+1
			    		   cstmt.setString(1, writer);
			    		   cstmt.setInt(2, 1);
			    		   cstmt.setInt(3, 0);
			    		   cstmt.setInt(4, 0);
			    		   cstmt.executeUpdate();			    		   
			    	   }
			       }

			       
			       pstmt = conn.prepareStatement(sql4);
			       pstmt.setInt(1, xnum);
			       pstmt.setString(2, xid);
			       res = pstmt.executeUpdate();
			       
			       rs.close();
			       cstmt.close();
			       pstmt.close();
			       conn.close();	    		   
//	    	   }
//	       }
	       
	    } catch (ClassNotFoundException | SQLException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
		
	}

}
