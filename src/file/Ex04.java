package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Ex04 {
	public static void main(String[] args) throws Exception {
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
		FileOutputStream fos = new FileOutputStream(filePAth);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		// 기본 스트림이 Byte형태의 자료형만 사용할 수 있던 반면
		// DataOutputStream을 사용하면 다양한 자료형을 자유롭게 쓸 수 있다.
		
		
		
		
		dos.writeUTF("김개똥");	// 문자열을 바로 보냄.
		dos.writeInt(100);		// 정수형을 바로 보냄. 외부파일에서는 'd'(아스키코드)로 표시됨
		dos.close();			// 스트림 닫음으로 외부파일에 보조저장된 내용 보냄(쓰기)
		
		
		
		
		// 아래는 반대로 외부에서 자바로 받아오기
		FileInputStream fis = new FileInputStream(filePAth);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		
		
		String name = dis.readUTF();
		int num = dis.readInt();
		System.out.println("name : "+ name);
		System.out.println("num : "+ num);
		
		//주목할 부분 
		//자바에서 외부로 파일을 보낼 때는 'output'
		//보낸 파일의 내용을 쓰기 할 때는 'write'

		//외부에서 자바로 파일을 불러올 때는 'input'
		//불러온 파일의 내용을 읽기 할 때는 'read'
		
	}
}
