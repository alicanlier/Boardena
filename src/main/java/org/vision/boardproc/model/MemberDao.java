package org.vision.boardproc.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
	public int insert(Member dto) throws SQLException;
	public int delete(String key) throws SQLException;
	public int delete2(String key) throws SQLException;
	public int update(Member dto) throws SQLException;
	public Member_View select(String key) throws SQLException;
	public List<Member_View> selectAll() throws SQLException;
	public String getPassword(final String id) throws SQLException;
	public int getAllCount() throws SQLException;
	//public List<RentMember> selectPart(int start,int end) throws SQLException;
	public int batch(List<Member> list) throws SQLException;
}
