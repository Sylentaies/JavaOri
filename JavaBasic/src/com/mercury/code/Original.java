package com.mercury.code;

public class Original implements Cloneable{
	private String str;
	
	public Original(){}
	
	public Original(String str){
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public Original clone() throws CloneNotSupportedException{
		 return (Original)super.clone();
	/*	 Original another = new Original(str);
		 return another;
		 will contain undefined field other than str*/
	
		 
	 }
}
