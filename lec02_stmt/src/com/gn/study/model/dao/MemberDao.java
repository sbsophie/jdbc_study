package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
// 	회원 탈퇴
	public int deleteMember(String memberId ,String memberPw ,int memberNo) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = ("DELETE FROM `member`"
					+ "WHERE m_no = "+memberNo);
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
// 회원정보 수정 -	
	public int updateMemberInfo(String memberName ,String memberPhone ,String memberEmail ,int memberNo) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			
			String sql = "UPDATE `member` "
					+"SET m_name = '"+memberName+"' "
					+",m_phone = '"+memberPhone+"' "
					+",m_email = '"+memberEmail+"' "
					+"WHERE m_no = "+memberNo;
			result = stmt.executeUpdate(sql);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
// 회원정보 수정 - 아이디와 비밀번호가 일치하는 정보 조회
	public Member selectMemberOneByIdAndPw(String memberId, String memberPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id='"+memberId+"' AND m_pw = '"+memberPw+"'");
			if(rs.next()) {
				m = new Member(rs.getInt("m_no"),rs.getString("m_id")
						,rs.getString("m_pw"));
			}
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
		return m;
	}
// 회원 이름으로 키워드 검색	
	public List<Member> searchKeyWord(String kw) {
		List<Member> list = new ArrayList<Member>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			System.out.println("조회된 결과는 다음과 같습니다.");
			rs = stmt.executeQuery("SELECT * FROM member where m_name LIKE '%"+""+kw+""+"%'");
			while(rs.next()) {
				m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
			}
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
		return list;
	}
	
// 회원 아이디 검색	
	public Member selectMemberOneById(String memId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member WHERE m_id = '"+memId+"'");
			if(rs.next()) {
				m = new Member(rs.getInt("m_no"),rs.getString("m_id")
						,rs.getString("m_pw"));
			}
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
		return m;
	}
// 회원 전체 조회	
	public List<Member> selectMemberAll() {
		// 전체 member 정보 조회 후 -> List<Member>정보로 return하기
		List<Member> list = new ArrayList<Member>();
		// DB에 SQL문 요청
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
			rs = stmt.executeQuery("SELECT * FROM member");
			while(rs.next()) {
				Member m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
// 회원 추가	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result =0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO MEMBER (m_id ,m_pw ,m_name ,m_email ,m_gender ,m_phone) "
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()
					+"','"+m.getMemberName()+"','"+m.getMemeberEmail()
					+"','"+m.getMemberGender()+"','"+m.getMemberPhone()+"')";
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
