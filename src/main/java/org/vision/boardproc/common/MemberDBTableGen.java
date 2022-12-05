package org.vision.boardproc.common;

import org.vision.boardproc.model.Member;

import com.sung.jdbc.dbtools.DBTableGenerator;


public class MemberDBTableGen {

	public static void main(String[] args) {
		//DBTableGenerator.generateDBTable(HotelMember.class, "oracle");
		//System.out.println("테이블생성완료");
		DBTableGenerator.dbGenerate("test_oracle", new Class[]{Member.class}, true); 
	}

}
