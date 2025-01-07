package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {
		private int projectId; // PK(번호)
		private String projectName; // 프로젝트명
		private int projectManager; // FK(employee의 emp_id) -> 관리자 사번
		private String managerName; // 관리자 이름
		private LocalDateTime regDate; // 등록일
		private LocalDateTime modDate; // 수정일
		
		public ProjectVo() {}
		
		public ProjectVo(int projectId, String projectName, int projectManager) {
			this.projectId = projectId;
			this.projectName = projectName;
			this.projectManager = projectManager;
		}

		public ProjectVo(int projectId, String projectName, int projectManager, String managerName,
				LocalDateTime regDate, LocalDateTime modDate) {
			super();
			this.projectId = projectId;
			this.projectName = projectName;
			this.projectManager = projectManager;
			this.managerName = managerName;
			this.regDate = regDate;
			this.modDate = modDate;
		}

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public int getProjectManager() {
			return projectManager;
		}

		public void setProjectManager(int projectManager) {
			this.projectManager = projectManager;
		}

		public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
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
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd (E)");
			
			String str = "";
			str += "ProjectVo [번호 : " + projectId;
			str += ", 이름 : " + projectName;
			
			if(projectManager != 0) {
				str += ", 관리자 : " + managerName +"("+projectManager +")";
			}else {
				str += ", 관리자 : " + managerName;
			}
			str += ", 등록일 : " + dtf.format(regDate);
			str += ", 수정일 : " + dtf.format(modDate) + "]";
			
			return str;
			
//			return "ProjectVo [번호 : " + projectId 
//					+ ", 이름 : " + projectName 
//					+ ", 관리자 : " + managerName +"("+projectManager +")"
//					+ ", 등록일 : " + dtf.format(regDate) 
//					+ ", 수정일 : " + dtf.format(modDate) + "]";
		}
		
		
		

		
		
		
		
		
		
		
		
}
