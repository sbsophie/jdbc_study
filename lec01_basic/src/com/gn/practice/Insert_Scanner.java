package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Insert_Scanner {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("이름 : ");
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);		
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			
			String str = sc.next();
			
			String sql1 = "SELECT t_no ,t_name ,t_date FROM test WHERE t_name='"+str+"'";
			rs = stmt.executeQuery(sql1);
			
			Test t = null;
			if(rs.next()) {
				int tNo = rs.getInt("t_no");
				String tName = rs.getString("t_name");
				LocalDateTime ldt = rs.getTimestamp("t_date").toLocalDateTime();
				t = new Test(tNo,tName,ldt);
			}
			
			if(t == null) {
				String sql2 = "INSERT INTO test(t_name) VALUES ('"+str+"')";
				int con = stmt.executeUpdate(sql2);
			} else {
				System.out.println("번호:"+t.getTestNo()+"이름:"+t.getTestName()
							+", 등록일"+t.getTestDate());
			}

			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			sc.close();
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		

	}

}
