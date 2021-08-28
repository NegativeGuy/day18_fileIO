package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
		FileOutputStream fos = new FileOutputStream(filePAth);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// fos(기본스트림)을 이용해서 bos(보조스트림)을 만들어준다.
		// 보조스트림(bos)를 쓰는 이유는
		// 기본스트림(fos)만 쓸 경우 반복문 처럼 여러번 스트림을 이용하게 되는 경우에
		// 반복하는 수 만큼 외부 경로와 접촉을 하기 때문에 비효율적이다
		// 보조스트림을 쓰면 자바 내부에서만 fos와 bos를 반복해서 변경사항을 기록하고
		// 마지막에 보조스트림을 통해 외부에 한번만 접촉하기 때문에 효율적이다
		
		
		for(char i = '1'; i<'9'; i++) {
			Thread.sleep(2000);
			//fos.write(i); 을 쓸 경우 1~9를 반복하는 동안 2초간격으로 외부파일에 접근하게 됨
			//비효율적임
			bos.write(i);
			// bos는 보조 저장소에 일단 데이터를 쌓아놈. 그러나 외부파일에는 아직 보내지 않음
			// 보내라는 신호와 같은 코드들을 만나야 됨(flush, close 등)
		}
		bos.flush();
		// bos를 외부파일로 보내는 신호.(flush는 '비운다'라는 뜻)
		bos.write('a');	// 저장소 내용에 'a' 추가
		bos.flush();	// 다시 추가된 'a'를 외부파일로 전송
		// bos.close();를 써도 외부파일로 보내는데 
		// close()를 쓸 경우 스트림이 닫치는 것이기 때문에
		// 이 후에 다시 내용을 추가( write() ) 할 수 없다.
	}
}
