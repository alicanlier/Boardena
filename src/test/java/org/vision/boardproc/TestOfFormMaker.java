package org.vision.boardproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.vision.boardproc.common.FormMaker;
import org.vision.boardproc.common.FormMaker.Inputs;
import org.vision.boardproc.common.FormMaker.Keys;

public class TestOfFormMaker {
	static FormMaker maker;
	public static void main(String[] args) {
		Map<Keys,List> listMap = new HashMap<Keys,List>();
		List<FormMaker.Inputs> list1 = new ArrayList<FormMaker.Inputs>();
		//public Inputs(String type, String caption, String name, int size) {
		list1.add(new FormMaker.Inputs("text","아이디:","id",30));
		list1.add(new FormMaker.Inputs("password","패스워드:","pass",30));
		list1.add(new FormMaker.Inputs("text", "이메일:","email",30));
		list1.add(new FormMaker.Inputs("text","연락처:","tel",30));
		list1.add(new FormMaker.Inputs("text","직업:","job",30));
		list1.add(new FormMaker.Inputs("text","취미:","hobby",30));
		ArrayList<FormMaker.Selects> list2 = new ArrayList<FormMaker.Selects>();
		list2.add(new FormMaker.Selects("age","10대","10대"));
		list2.add(new FormMaker.Selects("age","20대","20대"));
		list2.add(new FormMaker.Selects("age","30대","30대"));
		list2.add(new FormMaker.Selects("age","40대","40대"));
		list2.add(new FormMaker.Selects("age","50대","50대"));
		list2.add(new FormMaker.Selects("age","60대","60대"));
		list2.add(new FormMaker.Selects("age","70대이상","70대이상"));
		
		listMap.put(Keys.INPUT,list1);
		listMap.put(Keys.SELECT,list2);
				
		maker = new FormMaker("회원가입",listMap);
		String res = maker.getHTML();
		System.out.println(res);
	}

}
