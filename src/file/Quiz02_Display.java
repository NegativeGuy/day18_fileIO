package file;
// 프로그램의 기본 틀을 만듬
// 등록, 검색 등의 기능 구현
// 등록 시 Student_Info 객체 생성 후 객체에 각각의 정보 저장(set, get)
// file_In_Out 클래스의 파일로 저장하는 매서드를 여기서 호출
// ㅇ

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz02_Display {
	private Scanner sc = new Scanner(System.in);
	private String stNum, stName;
	private int kor, eng, math, score, avg;
	
	public void display() throws Exception{
		Quiz02_File_In_Out fio = new Quiz02_File_In_Out();
		Quiz02_Student_Info stInfo = new Quiz02_Student_Info();
		ArrayList<Quiz02_Student_Info> arr = new ArrayList<Quiz02_Student_Info>();
		
		while(true){			
			System.out.println("1.학생 등록 2.학생 검색 3.종료");
			System.out.print(">>>");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				while(true) {
					System.out.print("학번 입력 : ");
					stNum = sc.next();
					System.out.print("이름 입력 : ");
					stName = sc.next();
					System.out.print("국어 점수 : ");
					kor = sc.nextInt();
					System.out.print("영어 점수 : ");
					eng = sc.nextInt();
					System.out.print("수학 점수 : ");
					math = sc.nextInt();
					
					avg = (kor+eng+math)/3;
					if (avg >= 90)	stInfo.setStScore("A");
					else if (avg >=80)	stInfo.setStScore("B");
					else if (avg >=70)	stInfo.setStScore("C");
					else if (avg >=60)	stInfo.setStScore("D");
					else stInfo.setStScore("F");

					stInfo.setStNum(stNum);
					stInfo.setStName(stName);
					stInfo.setKor(kor);
					stInfo.setEng(eng);
					stInfo.setMath(math);
					stInfo.setAvg(avg);
					
					arr.add(stInfo);
					fio.fileOut(stInfo);
					System.out.println("등록이 완료 되었습니다.");
					
					break;
				}
				
			case 2:
				System.out.print("학번 입력 : ");
				stNum = sc.next();
				fio.fileIn(stNum);
				
				break;
			case 3: 
				System.out.println("종료합니다.");
				return;
			}
		}
	}
}
