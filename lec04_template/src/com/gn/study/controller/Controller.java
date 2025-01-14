package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// view로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();
/////////	
	public int signInMember(String id,String pw, String name,String email) {
		User u = new User(id,pw,name,email);
		int result = cd.signInMember(u);
		return result;
	}
	
	public int deleteCarOne(int carNo) {
		int result = service.deleteCarOne(carNo);
		return result;
	}
	//
	public int changeCarOne(int carNo ,String modelName) {
		int result = service.changeCarOne(carNo,modelName);
		return result;
	}
	public int changeCarPrice(int carNo ,int carPrice) {
		int result = service.changeCarPrice(carNo, carPrice);
		return result;
	}
	
	//
	
	public List<Car> searchCarList(int option ,Object obj){
		return service.searchCarList(option,obj);
	}
	
	public List<Car> selectCarAll(){
		return service.selectCarAll();
	}
	
	public int insertCarOne(String modelName ,int price ,String date) {
		Car car = new Car(modelName ,price ,date);
		int result = service.insertCarOne(car);
		return result;
	}

	public Car selectCarOne(String modelName) {
		return service.selectCarOne(modelName);
	}
}
