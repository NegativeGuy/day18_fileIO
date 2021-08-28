package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) throws Exception {
		// 본인의 디럭터리 아래 abcd1234 디렉터리를 만든 후 그 디렉터리 안에 test.txt 파일 생성
		// 이클립스 콘솔로 '이름','나이','주소'를 입력받고 test.txt 파일에 입력받은 값이 써지도록 하시오
		File filePath = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/abcd1234/test.txt");
		FileOutputStream fos = new FileOutputStream(filePath);
		Scanner sc = new Scanner(System.in);
		
		String name, addr, age;
		
		System.out.println("이름 입력");
		name = sc.next();
		name+="\n";	// 줄바꿈
		fos.write(name.getBytes());
		// Byte형태로 형변환하기 위해 .getBytes() 매서드를 씀
		
		System.out.println("나이 입력");
		age = sc.next();
		age+="\n";	// 줄바꿈
		fos.write(age.getBytes());
		
		System.out.println("주소 입력");
		addr = sc.next();
		fos.write(addr.getBytes());
	}
}
