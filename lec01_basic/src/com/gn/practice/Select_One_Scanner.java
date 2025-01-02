package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

import com.gn.study.model.vo.Test2;

public class Select_One_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT t_no ,t_name ,t_date"
					+ " FROM test"
					+ " WHERE t_no = " +su;

			rs = stmt.executeQuery(sql);
			
			Test2 t = new Test2();
			if(rs.next()) {
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
			}
			System.out.println(t.getTestNo()+t.getTestName()+t.date());
//			System.out.println(t);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
