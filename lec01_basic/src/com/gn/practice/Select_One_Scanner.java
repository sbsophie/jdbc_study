package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

import com.gn.study.model.vo.Test2;

public class Select_One_Scanner {

	public static void main(String[] args) {
//		[단일행 Select 연습하기]
//		사용자로부터 조회하고자 하는 행의 번호 입력받기
//		입력받은 번호를 t_no로 가지고 있는 행의 정보 조회
//		조회한 결과를 Vo에 담아서 출력하기
//		수업시간에 만든 것과 출력된 결과가 다릅니다. LocalDateTime을 그대로 사용하지 마시고, 날짜 형태를 형변환해서 출력할 수 있도록 toString 메소드를 수정하세요.
//		
//		조회하고자 하는 행의 번호를 입력하세요.
//		번호 : 2
//		번호:2, 이름:테스트2, 등록일:2024년05월15일 16시15분50초
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("조회하고자 하는 행의 번호를 입력하세요");
			System.out.println("번호");
			int num = sc.nextInt();
			
			// 1. DriveManager 찾기
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. connection 객체0 생성 
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			// 3. Statement 객체 생성
			stmt = conn.createStatement();
			// 4. SQL문 실행
			String sql = "SELECT t_no ,t_name ,t_date"
					+ " FROM test"
					+ " WHERE t_no = " +num;
			rs = stmt.executeQuery(sql);
			// 5. 결과 파싱
			Test2 t = new Test2();
			if(rs.next()) {
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
			}
			// 6. 결과 출력
			System.out.println(t.getTestNo()+t.getTestName()+t.date());
//			System.out.println(t);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
