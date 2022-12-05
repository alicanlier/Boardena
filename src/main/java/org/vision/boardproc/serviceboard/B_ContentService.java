package org.vision.boardproc.serviceboard;

import java.sql.*;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.vision.boardproc.model.*;
import org.vision.boardproc.common.*;

public class B_ContentService implements IService {

	private BoardDao dao;
	private SqlSession sqlSession = Constant.sqlSession;
	
	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		int xnum = Integer.parseInt(request.getParameter("num"));
		System.out.println("xnum: "+xnum);
		Boolean liking = Boolean.parseBoolean(request.getParameter("liking"));
//		Boolean isLiked = (Boolean)session.getAttribute("isLiked");
		dao = sqlSession.getMapper(BoardDao.class);
		
		String xid = (String)session.getAttribute("id");
		String writer = null;
		

		try {
			Comment_View dto = dao.select(xnum);
			writer = dto.getWriter();
			session.setAttribute("writer",writer);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    CallableStatement cstmt = null;
	    ConnFactory x = new ConnFactory();
	    Connection conn = null;
	    String sql = " select num, hit, liked from t_commenthitlike";
	      
		try {
			conn = x.getConnection();
			pstmt = conn.prepareStatement(sql);
			cstmt = conn.prepareCall("{call uphitlike(?,?,?)}");
			rs = null;
			rs = pstmt.executeQuery();
			
			System.out.println("liking: " + liking);
			
			if (liking == null || !liking) {
//				if (isLiked==null || !isLiked) {
						
					while(rs.next()) {
						if (xnum == rs.getInt("num")) {
							cstmt.setInt(1, xnum);
							cstmt.setInt(2, 1); //hit +1
							cstmt.setInt(3, 0);
							cstmt.executeUpdate();
						}
					}
					
//				}
			
			}
			
		    rs.close();
		    cstmt.close();
		    pstmt.close();
		    conn.close();	
		    
	    } catch (ClassNotFoundException | SQLException e) {
	       e.printStackTrace();
	    }

		int res = 0;
		String sql1 = "select num, memid from T_WHOLIKEDLOG";

		if(liking) {
//			if (isLiked==null || !isLiked) {
		
				try {
					
					conn = x.getConnection();
					pstmt = conn.prepareStatement(sql1);
					rs = pstmt.executeQuery();
					
					B_LikeCountService blc = new B_LikeCountService();
					
					if (rs.isBeforeFirst()) {
						
						System.out.println("2222liking: "+liking);
						System.out.println("2222rs: "+rs);
						
						while(rs.next()) {
							if (rs.getInt("num")==xnum && (rs.getString("memid")).equals(xid)) {
								System.out.println("2233rs: "+rs);
								System.out.println("xnum&xid: "+xnum+xid);
								Comment_View dto = dao.select(xnum);
								model.addAttribute("content",dto);
								model.addAttribute("request",request);
								return;
							}
						}
						
						blc.callLike(model, xid, writer, xnum);
						System.out.println("blc.callLike(model, xid, writer, xnum);");
						
					}else {
						
						System.out.println("3333liking: "+liking);

						
						blc.callLike(model, xid, writer, xnum);
					
	  			}
			       
			    } catch (ClassNotFoundException | SQLException e) {
			       e.printStackTrace();
			    }
//			}
		}
		
		try {
			Comment_View dto = dao.select(xnum);
			model.addAttribute("content",dto);
			model.addAttribute("request",request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
