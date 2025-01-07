package homework1.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MenuDao {

	public int insertMember(m){
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott"; 
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO MEMBER (m_id ,m_pw ,m_name ) "
					+ "VALUES ('"+m.getMemberId()+"','"+m.getMemberPw()
					+"','"+m.getMemberName();
			result = stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
		
	}
}
