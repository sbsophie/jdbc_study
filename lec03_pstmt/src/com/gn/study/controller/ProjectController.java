package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao();
// 프로젝트 삭제	
	public int deleteProjectOne(int projectNo) {
		int result = pd.deleteProjectOne(projectNo);
		return result;
	}
// 프로젝트 정보 수정		
	public int updateProjectOne(int projectNo ,String projectName) {
		int result = pd.updateProjectOne(projectNo ,projectName);
		return result;
	}
// 담당자기준으로 검색하여 담당프로젝트 정보 조회	
	public List<ProjectVo> searchByProjectManager(String managerName){
		List<ProjectVo> list = pd.searchByProjectManager(managerName);
		return list;
	}
// 프로젝트 이름 검색으로 관련정보 조회	
	public List<ProjectVo> selectProjectAllByName(String projectName){
		List<ProjectVo> list = pd.selectProjectAllByName(projectName);
		return list;
	}
// 프로젝트 전체 조회	
	public List<ProjectVo> selectProjectAll(){
		List<ProjectVo> list = pd.selectProjectAll();
		return list;
	}
// 프로젝트 추가	
	public int insertProjectOne(String projectName, String managerName) {
		int result = pd.insertProjectOne(projectName, managerName);
		return result;
	}
}
