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
import org.vision.boardproc.common.*;
import org.vision.boardproc.model.*;

public class B_LikeCountService {

	
	public void callLike(Model model, String xid, String writer, int xnum) {
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
//		session.setAttribute("isLiked",true);

//		int xnum = Integer.parseInt(request.getParameter("num"));
//		String xid = (String)session.getAttribute("id");
//		String writer = null;
//		System.out.println("B_LikeService is executed.");
//
//		dao = sqlSession.getMapper(BoardDao.class);
		
		ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    CallableStatement cstmt = null;
	    ConnFactory x = new ConnFactory();
	    Connection conn = null;
//	    String sql = " select num, hit, liked from t_commenthitlike";


	    int res = 0;
	    String sql1 = "select num, memid from T_WHOLIKEDLOG";
	    String sql2 = "select num, hit, liked from t_commenthitlike";
	    String sql3 = "select id, receivedlike, pushedlike, com_count from T_MEMBERACTIVITY";
	    String sql4 = "insert into T_WHOLIKEDLOG(num, memid) values(?,?)";
	    
     
		try {
			conn = x.getConnection();
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
			System.out.printf("xid:%s, writer:%s, xnum:%d",xid,writer,xnum);
			while(rs.next()) {
				if (xid.equals(rs.getString("id"))) { //pushedlike+1 
					System.out.println("\npushedlike+1 ");
					cstmt.setString(1, xid);
					cstmt.setInt(2, 0);
					cstmt.setInt(3, 1);
					cstmt.setInt(4, 0);
					cstmt.executeUpdate();
				} 
				
				if (writer != null && writer.equals(rs.getString("id"))) { //receivedlike+1
					System.out.println("\nreceivedlike+1");
					cstmt.setString(1, writer);
					cstmt.setInt(2, 1);
					cstmt.setInt(3, 0);
					cstmt.setInt(4, 0);
					cstmt.executeUpdate();			    		   
				}
			}
			   
			pstmt = conn.prepareStatement(sql4); //wholiked+1
			pstmt.setInt(1, xnum);
			pstmt.setString(2, xid);
			res = pstmt.executeUpdate();
			   
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
