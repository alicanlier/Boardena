package org.vision.boardproc.model;

public class Member_View {
	private String id;
	private String pass;
	private String name;
	private String email;
	private String tel;
	private String age;
	private String job;
	private String hobby;
	private int receivedlike;
	private int pushedlike;
	private int com_count;
	private int active_status;
	
	public Member_View() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member_View(String id, String pass, String name, String email, String tel, String age, String job,
			String hobby, int receivedlike, int pushedlike, int com_count, int active_status) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
		this.receivedlike = receivedlike;
		this.pushedlike = pushedlike;
		this.com_count = com_count;
		this.active_status = active_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getReceivedlike() {
		return receivedlike;
	}

	public void setReceivedlike(int receivedlike) {
		this.receivedlike = receivedlike;
	}

	public int getPushedlike() {
		return pushedlike;
	}

	public void setPushedlike(int pushedlike) {
		this.pushedlike = pushedlike;
	}

	public int getCom_count() {
		return com_count;
	}

	public void setCom_count(int com_count) {
		this.com_count = com_count;
	}

	public int getActive_status() {
		return active_status;
	}

	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}

	@Override
	public String toString() {
		return "Member_View [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", age=" + age + ", job=" + job + ", hobby=" + hobby + ", receivedlike=" + receivedlike
				+ ", pushedlike=" + pushedlike + ", com_count=" + com_count + ", active_status=" + active_status + "]";
	}

}
