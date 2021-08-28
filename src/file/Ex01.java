package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex01 {
	public static void main(String[] args) throws Exception { 
		// 아래 FileOutputStream가 오류나서 throws Exception(예외처리) 해준다
		
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
	    //해당 경로에 aaa.txt 파일을 생성
		
		FileOutputStream fos = new FileOutputStream(filePAth);	// (filePAth, true)
		// filePAth만 쓰고 true가 없으면 기존의 내용이 지워지고 새로운 내용으로 덮어쓰기 된다
		// 기존의 내용을 계속 유지하면서 새로운 내용을 이어서 쓰고 싶으면 (filePAth, true)로 써준다
		
		// 생성한 aaa.txt 파일에 글 쓰기
		fos.write(97);	//아스키코드 'a'
		fos.write('A');
		
		// 직접 글을 쓰지 않고 변수를 통해서 변수 값을 파일에 쓰기
		String name = "English";
		String name1 = "한글";
		fos.write(name.getBytes());
		fos.write(name1.getBytes());
		// .write()는 Byte형태만 받아주기 때문에 String형은 .getBytes()를 해줘야 한다

	}
}
