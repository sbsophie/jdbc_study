package com.gn.study.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public int deleteMember(String memberId ,String memberPw ,int memberNo) {
		return new MemberDao().deleteMember(memberId ,memberPw,memberNo);
	}
	
	public int updateMemberInfo(String memberName ,String memberPhone ,String memberEmail,int memberNo) {
		return new MemberDao().updateMemberInfo(memberName, memberPhone,memberEmail,memberNo);
	}
	
	public Member selectMemberOneByIdAndPw(String memberId ,String memberPw) {
		return new MemberDao().selectMemberOneByIdAndPw(memberId,memberPw);
	}
	
	public List<Member> searchKeyWord(String kw) {
		return new MemberDao().searchKeyWord(kw);
	}
	
	public Member selectMemberOneById(String memberId) {
//		Member m = new MemberDao().selectMemberOneById(memberId);
//		return m;
		return new MemberDao().selectMemberOneById(memberId);
	}
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	public int insertMember(String memberId ,String memberPw ,String memberName
			,String memberEmail ,String memberPhone ,String memberGender) {
		Member m = new Member(memberId,memberPw,memberName,memberEmail
				,memberPhone,memberGender);
		
		int result = new MemberDao().insertMember(m);
		return result;
		
	}
	
}
