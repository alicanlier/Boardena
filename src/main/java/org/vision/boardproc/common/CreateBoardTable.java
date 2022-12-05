package org.vision.boardproc.common;

import org.vision.boardproc.model.Board;

import com.sung.jdbc.dbtools.DBTableGenerator;


public class CreateBoardTable {

	public static void main(String[] args) {
		DBTableGenerator.dbGenerate("test_oracle2",new Class[]{ Board.class}, true);

	}

}
