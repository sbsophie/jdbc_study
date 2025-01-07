package homework1.model.vo;

import java.time.LocalDateTime;

public class Menu {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime regDate;
	
	public Menu() {}
	
	public Menu(int userNo, String userId, String userPw, String userName, LocalDateTime regDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Menu [userNo=" + userNo 
				+ ", userId=" + userId 
				+ ", userPw=" + userPw 
				+ ", userName=" + userName
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	
}
