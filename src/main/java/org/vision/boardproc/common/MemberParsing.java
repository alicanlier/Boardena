package org.vision.boardproc.common;

import org.vision.boardproc.model.Member;

public class MemberParsing {
	public static Member parsing(String target) throws Exception{
		//"sjw/1234/sjw/jaain@naver.com/010-2307-3558/60대/교수/등산"
		String[] tokens = target.split("/");
		Member mem = new Member();
		String errormsg="";
		try {
			mem.setId(tokens[0]);
			errormsg="password can be anything but null.";
			mem.setPass(tokens[1]);
			errormsg="name can be anything but null.";
			mem.setName(tokens[2]);
			errormsg="email can be anything but null.";
			mem.setEmail(tokens[3]);
			errormsg="tel can be anything but null.";
			mem.setTel(tokens[4]);
			mem.setAge(tokens[5]);
			mem.setJob(tokens[6]);
			mem.setHobby(tokens[7]);
		} catch (Exception e) {
			System.err.println(errormsg);
			e.printStackTrace();
		}
		return mem;
	}

	public static void main(String[] args) throws Exception {
		String target = "sjw/1234/sjw/jaain@naver.com/010-2307-3558/60대/교수/등산";
		Member x = MemberParsing.parsing(target);
		System.out.println(x);
		// 또다른 방식 공통모듈(common tool) Parsing4Batch의 활용 
		String[] setters = new String[] { 
				"setId", "setPass",  "setName", "setEmail", "setTel", "setAge", "setJob", "setHobby" };
		Parsing4Batch parser = new Parsing4Batch(Member.class, "/");
		Member y =(Member)parser.parsing(target, setters);
		System.out.println(y);
	}
}

