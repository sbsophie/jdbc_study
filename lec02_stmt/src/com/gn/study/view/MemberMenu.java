package com.gn.study.view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	// View : 사용자와의 상호작용
	public void mainMenu() {
		System.out.println("환영합니다!!");
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
				case 3 : searchMemberOneById();break;
				case 4 : searchKeyWord();break;
				case 5 : updateMember();break;
				case 6 : deleteMember();break;
				case 0 : System.out.println("잘가요~안녕~");return;
				default : System.out.println("잘못된 번호입니다.");break;
			}
		}
	}
	
	// 회원 탈퇴
	public void deleteMember() {
		System.out.println("=== 회원 탈퇴 ===");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		
		Member m = mc.selectMemberOneByIdAndPw(id,pw);
		if(m != null) {
			System.out.println(m);
			
		int result = mc.deleteMember(id, pw,m.getMemberNo());
		if(result >0) {
			System.out.println("성공적으로 삭제되었습니다.");
		}else {
			System.out.println("삭제중 오류가 발생했습니다.");
		}
	  }
	}
	
	// 회원정보 수정
	public void updateMember() {
		// 관리자 -> 모든 회원 정보 수정
		// 사용자 -> 내것만 수정
		System.out.println("=== 회원 정보 수정 ===");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		
		Member m = mc.selectMemberOneByIdAndPw(id,pw);
		if(m != null) {
			System.out.println(m);
			// 이메일,전화번호,이름 정보 입력받아서 수정
			System.out.println("이름 : ");
			String name = sc.nextLine();
			System.out.println("전화번호 : ");
			String phone = sc.nextLine();
			System.out.println("이메일 : ");
			String email = sc.nextLine();
			
			int result = mc.updateMemberInfo(name,phone,email,m.getMemberNo());
			if(result >0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패ㅜㅜ");
			}
		}else {
			System.out.println("잘못된 아이디 혹은 비밀번호입니다.");
		}
		
	}
	
	// 회원 이름으로 키워드 검색
	public void searchKeyWord() {
		System.out.println("=== 이름 키워드 검색 ===");
		System.out.println("키워드 : ");
		String kw = sc.nextLine();
		List<Member> list = mc.searchKeyWord(kw);
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Member m : list)
				System.out.println(m);
		}
	}
	
	// 아이디 기준 회원 조회
	public void searchMemberOneById() {
		System.out.println("=== 회원 아이디 검색 ===");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		// where조건사용할때  -> =(UNIQUE하거나 아니거나) / LIKE
		Member m = mc.selectMemberOneById(id);
		if(m != null) {
			System.out.println(m);
		}else {
			System.out.println(id+"는 존재하지 않는 정보입니다.");
		}
	}
	
	
	// 전체 회원 조회
	public void selectMemberAll() {
		System.out.println("=== 회원 전체 조회 ===");
		List<Member> list = mc.selectMemberAll();
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		} else {
			for(Member m : list)
			System.out.println(m);
		}
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
