package file;
//역직렬화(ObjectInputStream) (test05 참조)
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class Ex06 {
	public static void main(String[] args) throws Exception {
		File filePAth = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/aaa.txt");
		FileInputStream fis = new FileInputStream(filePAth);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		test05 t = (test05)ois.readObject();
		// object타입으로 받아오기 때문에 (test05)로 형변환을 해줌
		
		t.print();
		
	}
}
