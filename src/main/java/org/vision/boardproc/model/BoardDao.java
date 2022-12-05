package org.vision.boardproc.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public interface BoardDao {
	public int insert(Board bean) throws SQLException;
	public int insert2(Board bean) throws SQLException;
	public List<Comment_View> selectAll() throws SQLException;
	public Comment_View select(int num) throws SQLException;
	public List uphitlike(Map<String, Integer> call) throws SQLException;
	public int update(Board bean) throws SQLException;
	public int delete(int key) throws SQLException;
	public int delete2(int key) throws SQLException;
	public int getAllCount() throws SQLException;
}
