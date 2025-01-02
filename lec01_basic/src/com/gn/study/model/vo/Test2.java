package com.gn.study.model.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Test2 {
	private int testNo;
	private String testName;
	private LocalDateTime testDate;
	
	public Test2() {}

	public Test2(int testNo, String testName, LocalDateTime testDate) {
		super();
		this.testNo = testNo;
		this.testName = testName;
		this.testDate = testDate;
	}

	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalDateTime getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDateTime testDate) {
		this.testDate = testDate;
	}
	
	public String date() {
		Calendar cal = Calendar.getInstance();
		cal.set(testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth()
				, testDate.getHour(), testDate.getMinute(), testDate.getSecond());
		
		Date date = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		return sdf.format(date);
		
	}
	
	@Override
	public String toString() {
		return "번호"+testNo+",이름:"+testName+",등록일:"+testDate;  //testDate부분을 date
	}
	
	
	
	
	
	
}
