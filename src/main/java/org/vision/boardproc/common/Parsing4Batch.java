package org.vision.boardproc.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.vision.boardproc.model.Member;


public class Parsing4Batch {
	private Class clazz;
	private String regex;

	public Parsing4Batch(Class clazz, String regex) {
		this.clazz = clazz;
		this.regex = regex;
	}

	public Object parsing(String target, String... settersName) throws Exception {
		String[] tokens = target.split(regex);
		Object obj = null;
		// -------------------------------------
		// 문제는 여기에서 만들어지는 배열순서를 예측할 수 없고
		// 토큰들의 순서가 같지 않다는데 있다. 이를 해결해야 한다.
		Method[] methods = clazz.getMethods();
		obj = clazz.newInstance();
		List<Method> setters = new ArrayList<Method>();
		for (int i = 0; i < methods.length; i++) {
			if (!methods[i].getName().startsWith("set"))
				continue;
			setters.add(methods[i]);
		}
		// 토큰의 성질에 맞는 세터를 불러 실행
		for (int i = 0; i < tokens.length; i++) {
			String setterName = settersName[i];
			String paraType = "";
			for (Method x : setters) {
				if (x.getName().equals(setterName)) {
					Class<?>[] p = x.getParameterTypes();
					paraType = (p[0].getSimpleName());
					Method y = null;
					switch (paraType) {
					case "int":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Integer.parseInt(tokens[i]));
						break;
					case "String":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, tokens[i]);
						break;
					case "long":
						y = clazz.getMethod(setterName, p[0]);
						y.invoke(obj, Long.parseLong(tokens[i]));
						break;
					// .........필요하면 늘리세요
					}
				}
			}
		}
		return obj;
	}

	// 사용법
	public static void main(String[] args) throws Exception {
		Parsing4Batch parser = new Parsing4Batch(Member.class, "/");
		String[] setters = new String[] { "setId", "setPass", "setEmail", "setTel", "setAge", "setJob", "setHobby" };
		Member mem = (Member) parser.parsing("sjw/1234/jaain@naver.com/010-2307-3558/60대/교수/등산", setters);
		System.out.println(mem);
	}
}