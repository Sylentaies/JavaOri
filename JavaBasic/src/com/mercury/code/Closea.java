package com.mercury.code;

public class Closea{
	
	private String name;
	private int age;
	public Closea(){}
	public Closea(String name,int age){
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) return false;
		if (!(obj instanceof Closea)){
			return false;
		}else{
			Closea n1 =(Closea)obj;
			return name.equals(n1.getName());
		}
		
	}

	
	

}
