package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Member implements Serializable{
	private String stNum, stName, stScore;
	private int kor, eng, math;
	
	// 셋터 겟터 생성
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStScore() {
		return stScore;
	}
	public void setStScore(String stScore) {
		this.stScore = stScore;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {

		this.math = math;
	}
	
	// ArrayList arr을 파라미터로 받는 매서드
	// 학번 비교하는 기능
	public boolean chkStNum(ArrayList<Member> arr) {
		for(Member m : arr) {	
			// for each문 활용 Member m에 차례대로(arr의 size만큼) 대입
			// 첫번째 반복에선 arr[0]의 값들이 m에 저장됨
			// 그럼 아래 if문에서 arr[0]의 값 중 getStNum을 꺼내와 입력된 stNum과 비교
			if(m.getStNum().equals(this.stNum)==true)
				return true;
		}
		return false;
	}
	
	public boolean searchSt(ArrayList<Member> arr, String stNum) {
		for(Member m : arr) {
			if(m.getStNum().equals(stNum)==true) {
				setStNum(stNum);
				setStName(m.getStName());
				setKor(m.getKor());
				setEng(m.getEng());
				setMath(m.getMath());
				setStScore(m.getStScore());
				return true;
			}
		}// for문 종료
		return false;
	}
}

class FileInOut {
	// 출력 기능 매서드
	public void fileOut(Member outMember) throws Exception {
		File dir = new File("C:\\Users\\NegativeGuy\\Desktop\\스프링클라우드\\java\\lesson_files\\day18_fileIO\\file");
		File f3 = new File(dir, outMember.getStNum()+".txt");
		
		FileOutputStream fos = new FileOutputStream(f3);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject((Object)outMember);
		oos.close();
	}
	
	// 입력(파일 읽기) 기능 매서드
	public Member fileRead(String stNum) throws Exception {
		Member mb = null;
		File dir = new File("C:\\Users\\NegativeGuy\\Desktop\\스프링클라우드\\java\\lesson_files\\day18_fileIO\\file");
		File f3 = new File(dir, stNum+".txt");
		try {
			FileInputStream fis = new FileInputStream(f3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			mb = (Member)ois.readObject();
			ois.close();
		}catch(FileNotFoundException e){
			return null;
		}
		return mb;
	}
	
	//파일 체크 기능 매서드
	public boolean chkFile(String stNum) throws Exception {
		File dir = new File("C:\\Users\\NegativeGuy\\Desktop\\스프링클라우드\\java\\lesson_files\\day18_fileIO\\file");
		File f3 = new File(dir, stNum+".txt");
		if(f3.createNewFile()) {
			return false;	// 현재 파일이 존재하면 true
		}
		return true;
	}
}
public class Quiz02 {
	public static void main(String[] args) throws Exception {
		FileInOut outMember = new FileInOut();
		
		Scanner input = new Scanner(System.in);
		ArrayList<Member> arr = new ArrayList<Member>();
		String stNum, stName, stScore;
		int kor, eng, math, avr;
		int num;
		boolean bl;
		while(true) {
			System.out.println("1. 학생 검색");
			System.out.println("2. 학생 등록");
			System.out.println("3. 종료");
			System.out.print(">>>");
			num = input.nextInt();
			Member mb = new Member();
			switch(num) {
			case 1:
				System.out.print("학번 입력 : ");
				stNum = input.next();
				bl = mb.searchSt(arr, stNum);
				if(bl == true || mb != null) {
					System.out.println("학번 : "+mb.getStNum());
					System.out.println("이름 : "+mb.getStName());
					System.out.println("국어 : "+mb.getKor());
					System.out.println("영어 : "+mb.getEng());
					System.out.println("수학 : "+mb.getMath());
					System.out.println("등급 : "+mb.getStScore());
				}else {
					System.out.println("존재하지 않는 학번 입니다.");
				}
				break;
				
			case 2:
				bl = true;
				while(bl) {
					System.out.print("학번 입력 : ");
					stNum = input.next();
					mb.setStNum(stNum);
					bl = mb.chkStNum(arr);
					bl = outMember.chkFile(stNum);
					if(bl == true) {
						System.out.println("존재하는 학번 입니다.");
						System.out.println("다시 입력 해주세요.");
					}
				}
				System.out.print("이름 입력 : ");
				stName = input.next();
				
				System.out.print("국어 점수 입력 : ");
				kor = input.nextInt();
				
				System.out.print("영어 점수 입력 : ");
				eng = input.nextInt();

				System.out.print("수학 점수 입력 : ");
				math = input.nextInt();
				
				mb.setStName(stName);
				mb.setKor(kor);
				mb.setEng(eng);
				mb.setMath(math);
				
				avr = (kor+eng+math)/3;
				
				if(avr >= 90) {
					mb.setStScore("A");
				}
				else if(avr >= 80) {
					mb.setStScore("B");
				}
				else if(avr >= 70) {
					mb.setStScore("C");
				}
				else if(avr >= 60) {
					mb.setStScore("D");
				}
				else {
					mb.setStScore("F");
				}
				
				arr.add(mb);
				outMember.fileOut(mb);
				System.out.println("가입이 완료 되었습니다");
				break;
				
			case 3: return;
			}
		}
	}
}
