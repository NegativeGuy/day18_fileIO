package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Quiz02_File_In_Out {
	File filePath;
	File stFile;
	
	FileOutputStream fos;
	BufferedOutputStream bos;
	ObjectOutputStream oos;
	
	FileInputStream fis;
	BufferedInputStream bis;
	ObjectInputStream ois;
	
	public void fileOut(Quiz02_Student_Info stInfo) throws Exception {
		filePath = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/");
		stFile = new File(filePath,stInfo.getStNum()+".txt" );
		
		fos = new FileOutputStream(stFile);
		bos = new BufferedOutputStream(fos);
		oos = new ObjectOutputStream(bos);
		
		oos.writeObject((Object)stInfo);
		oos.close();
		
	}
	
	public Quiz02_Student_Info fileIn(String stNum) throws Exception {
		filePath = new File("C:/Users/NegativeGuy/Desktop/스프링클라우드/test/");
		stFile = new File(filePath,stNum+".txt" );
		
		fis = new FileInputStream(stFile);
		bis = new BufferedInputStream(fis);
		ois = new ObjectInputStream(bis);
		
		Quiz02_Student_Info stInfo = (Quiz02_Student_Info)ois.readObject();
		ois.close();
		return stInfo;
		
	}

	
}
