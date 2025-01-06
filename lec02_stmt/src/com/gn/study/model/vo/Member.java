package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memeberEmail;
	private String memberPhone;
	private String memberGender;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public Member() {}
	
	public Member(int memberNo ,String memberId ,String memberPw) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.regDate = LocalDateTime.now();
		this.modDate = LocalDateTime.now();
	}
	
	public Member(String memberId, String memberPw, String memberName, String memeberEmail,
			String memberPhone, String memberGender) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memeberEmail = memeberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
	}
	
	public Member(int memberNo, String memberId, String memberPw, String memberName, String memeberEmail,
			String memberPhone, String memberGender, LocalDateTime regDate, LocalDateTime modDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memeberEmail = memeberEmail;
		this.memberPhone = memberPhone;
		this.memberGender = memberGender;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemeberEmail() {
		return memeberEmail;
	}

	public void setMemeberEmail(String memeberEmail) {
		this.memeberEmail = memeberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return "회원 [번호=" + memberNo + ", 아이디=" + memberId 
				+ ", 비밀번호=" + memberPw 
				+ ", 이름=" + memberName 
				+ ", 이메일=" + memeberEmail 
				+ ", 전화번호=" + memberPhone 
				+ ", 성별=" + memberGender 
				+ ", 가입일=" + dtf.format(regDate)
				+ ", 수정일=" + dtf.format(modDate) + "]";
	}
	
	
	
	
	
	
	
}
