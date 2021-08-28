package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
		//파일 경로 지정
		
		// 파일이 있는 경로와 자바를 잇는 스트림 생성(
		FileInputStream fis = new FileInputStream(filePAth);
		// 해당 파일을 자바(이클립스)로 불러올 준비과정(연결만 된 상태)
		
		// 이제 불러와서 콘솔에 띄우는 작업
		while(true) {
			int res = fis.read();
			// read()로 파일의 값을 하나씩 가져와서 res로 대입하는 과정을 반복
			// 파일의 끝은 eof로 되어있고 -1의 값을 가지고 있다
			// 그래서 아래 if문으로 -1이 들어오면 0보다 작으므로 break를 실행
			if(res<0) {
				break;
			}
			System.out.println((char)res);
			// int형으로 res를 만들었으므로 모두 숫자로 값이 들어오는데 이를 (char)로 형변환
			// int로 한 이유는 eof값(-1)을 받아야 하므로
		}
	}
}
