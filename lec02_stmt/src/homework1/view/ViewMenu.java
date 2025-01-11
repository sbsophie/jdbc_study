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
			System.out.println("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 :signIn();break;
				case 2 :login();break;
				case 0 :System.out.println("이요해주셔서 감사합니다.");return;
				default :System.out.println("메뉴를 잘못 입력하셨습니다.");break;
			}
		}
	}
	
	public void signIn() {
		System.out.println("=== 회원가입 ===");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		
			
	}
	
}
