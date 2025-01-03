package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// View : 사용자와의 상호작용
	public void mainMenu() {
		System.err.println("환영합니다!!");
		// 사용자에게 정보 입력받아서
		//Controller에게 전달
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1 : createMember();break; //내가 나를 부를때는 객체화할 필요 없다
				case 2 : selectMemberAll();break;
				case 0 : System.out.println("잘가요~안녕~");return;
				default : System.out.println("잘못된 번호입니다.");break;
			}
		}
	}
	
	// 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.selectMemberAll();
		// (1)만약에 list가 비어있다면 -> 조회된 결과가 없습니다.
		// (2)만약에 list가 비어있지 않다면 Member목록을 출력
	}
	
	
	
	// 회원 추가 화면
	public void createMember() {
		System.out.println("=== 회원 정보 추가 ===");
		System.out.println("아이디 : ");
		String memberId = sc.nextLine();
		System.out.println("비밀번호 : ");
		String memberPw = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		System.out.println("성별 : ");
		String memberGender = sc.nextLine();
		
		int result = mc.insertMember(memberId, memberPw, memberName, memberEmail, memberPhone, memberGender);
		if(result >0) {
			System.out.println("성공!!");
		}else {
			System.out.println("실패ㅠㅠ");
		}
	}
	
	
	
	
}