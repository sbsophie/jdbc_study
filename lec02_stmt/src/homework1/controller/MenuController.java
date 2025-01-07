package homework1.controller;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

import homework1.model.dao.MenuDao;

public class MenuController {
	private MenuDao md = new MenuDao();
	
	public int insertMember(String id,String pw,String name) {
		Member m = new Member(id,pw,name);
		int result = md.insertMember(m);
		return result;
	}
}
