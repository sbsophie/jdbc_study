package homework1.view;

import java.util.Scanner;

import homework1.controller.MenuController;

public class ViewMenu {
	private Scanner sc = new Scanner(System.in);
	private MenuController mc = new MenuController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== Watermelon Music ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 음악 추가");
			System.out.println("4. 음악 인기 순위 조회");
			System.out.println("5. 음악 재생");
			System.out.println("6. 개인 정보 수정");
			System.out.println("7. 회원 탈퇴");
			System.out.println("0. 시스템 종료");
			
			System.out.println("메뉴 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 :break;
				case 2 :break;
				case 3 :break;
				case 4 :break;
				case 5 :break;
				case 6 :break;
				case 7 :break;
				case 0 :System.out.println("바이바이~");return;
				default :System.out.println("잘못된 번호입니다.");break;
			}
			
		}
		
	}
}
