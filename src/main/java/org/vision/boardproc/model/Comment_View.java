package org.vision.boardproc.model;

import java.sql.Date;

public class Comment_View {
	private int num;
	private String writer;
	private String subject;
	private Date reg_date;
	private int ref;// 게시글그룹 
	private int re_step;// 게시순서 
	private int re_level;// 들여쓰기레벨 
	private String content;// 게시글내용 
	private int hit;
	private int liked;
	
	public Comment_View() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment_View(int num, String writer, String subject, Date reg_date, int ref, int re_step, int re_level,
			String content, int hit, int liked) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.reg_date = reg_date;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.content = content;
		this.hit = hit;
		this.liked = liked;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	
	@Override
	public String toString() {
		return "Comment_View [num=" + num + ", writer=" + writer + ", subject=" + subject + ", reg_date=" + reg_date
				+ ", ref=" + ref + ", re_step=" + re_step + ", re_level=" + re_level + ", content=" + content + ", hit="
				+ hit + ", liked=" + liked + "]";
	}
	

	
	
}