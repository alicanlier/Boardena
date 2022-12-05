package org.vision.boardproc.model;

public class Member {
	private String id;
	private String pass;
	private String name;
	private String email;
	private String tel;
	private String age;
	private String job;
	private String hobby;
	private String join_date;
	private int active_status;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pass, String name, String email, String tel, String age, String job, String hobby,
			String join_date, int active_status) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
		this.join_date = join_date;
		this.active_status = active_status;
	}
	
	
	public Member(String id, String pass, String name, String email, String tel, String age, String job, String hobby) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
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

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public int getActive_status() {
		return active_status;
	}

	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + active_status;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((join_date == null) ? 0 : join_date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (active_status != other.active_status)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (join_date == null) {
			if (other.join_date != null)
				return false;
		} else if (!join_date.equals(other.join_date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", tel=" + tel + ", age="
				+ age + ", job=" + job + ", hobby=" + hobby + ", join_date=" + join_date + ", active_status="
				+ active_status + "]";
	}
	
	
	

	
	
	
	
}
