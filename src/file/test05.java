package file;

import java.io.Serializable;

public class test05 implements Serializable{ 
	// 직렬화하기 위해선 Serializable를 상속해야 함
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("name : "+name);
	}
}
