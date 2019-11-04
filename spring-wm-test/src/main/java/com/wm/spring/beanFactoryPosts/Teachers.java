package com.wm.spring.beanFactoryPosts;

public class Teachers {
	/**
	 * 老师的姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private int age;

	/**
	 * 是否抽烟
	 */
	private boolean smoking;

	/**
	 * 老师教授的课程
	 */
	private String language;



	public Teachers() {

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void teach(){
		System.out.println("I am :"+name+" and I will teach you :"+language + " and I "+(smoking?"will":"will not")+" smoking");
	}

}
