package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
//직렬화(ObjectOutputStream) (test05 참조)
//직렬화는 객체형태(변수, 매서드 등)를 외부로 보내기 위해 Byte형태로 변환하는 것
//역직렬화는 외부의 Byte화 된 값을 다시 객체화 시키는 것
public class Ex05 {
	public static void main(String[] argsth) throws Exception {
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
		FileOutputStream fos = new FileOutputStream(filePAth);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		Scanner input = new Scanner(System.in);
		System.out.println("이름 입력");
		String name = input.next();
		
		test05 t = new test05();
		t.setName(name);
		
		oos.writeObject(t);	
		// 여기서 t는 객체화 상태이지만 ObjectOutputStream을 사용해서 직렬화(Byte화) 시켜줌
		
		oos.close();
	}
}
