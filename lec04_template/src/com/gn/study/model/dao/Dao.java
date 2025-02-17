package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;

public class Dao {
	/////////
	public int signInMember(User u) {
		Connection conn = null;
		Statement stmt = null;
		int result =0;
		
		try {
			String sql = "INSER INTO user(user_id,user_pw,user_name,user_email)"
					+"VALUES('"+u.getUserId()
					+"'," + u.getUserPw()
					+"','"+ u.getUserName()
					+"','"+ u.getUserEmail() +"')'";
		result=stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			stmt.close();
			conn.close();
		}
		return result;
	}
	/////////
	public int selectMemerOneById(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		int cnt =0;
		
		try {
			String sql = "SELECT COUNT(*) "
					+"FROM user "
					+"WHERE user_id = '"+id+"'";
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			cnt=rs.getInt(1);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return cnt;
	}
	
	public int deleteCarOne(int carNo, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "DELETE FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carNo);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//
	public int changeCarOne(int carNo ,String modelName,Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE car "
					+ "SET car_model = ? "
					+ "WHERE car_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modelName);
			pstmt.setInt(2, carNo);
			result = pstmt.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int changeCarPrice(int carNo ,int carPrice,Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE car "
					+ "SET car_price = ? "
					+ "WHERE car_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carPrice);
			pstmt.setInt(2, carNo);
			result = pstmt.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	//
	public List<Car> searchCarList(int option, Object obj,Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car WHERE ";
			switch(option) {
				case 1 : sql += "car_no = "+(Integer)obj; break;
				case 2 : sql += "car_model = '"+(String)obj+"'"; break;
				case 3 : sql += "car_price = "+(Integer)obj; break;
				case 4 : sql += "car_date = '"+(String)obj+"'"; break;
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));	
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
				list.add(car);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list; 
	}
	
	public Car selectCarOne(Connection conn ,String modelName){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		Car car = null;
		
		try {
			String sql = "SELECT * "
					+ "FROM car "
					+ "WHERE car_model = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,modelName);
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date")!= null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}

				list.add(car);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return car;
	}
	
	public List<Car> selectCarAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		
		try {
			String sql = "SELECT * FROM car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
//				Car car = new Car(rs.getInt("car_no")
//						,rs.getString("car_model")
//						,rs.getInt("car_price")
//						,sdf.format(rs.getDate("car_date")));
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date")!= null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				}else {
					car.setCarDate("(-)");
				}
					
				
				list.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	public int insertCarOne(Car car, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql ="INSERT INTO car (car_model ,car_price ,car_date) "
					+ "VALUES(?,?,STR_TO_DATE(?,'%Y-%m-%d')) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
