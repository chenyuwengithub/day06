package cn.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Employee;
import cn.jiyun.service.UserService;

@Controller
@ResponseBody
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("findAll")
	public List<Employee> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("findDepts")
	public List<Dept> findDepts(){
		return userService.findDepts();
	}
	
	@RequestMapping("add")
	public String add(@RequestBody Employee employee){
		Integer eid = employee.getEid();
		if(eid==null){
			userService.add(employee);
		}else{
			userService.update(employee);
		}
		return "0";
	}
	@RequestMapping("del")
	public String del(Integer eid){
		userService.del(eid);
		return "0";
	}
	
	@RequestMapping("findByid")
	public Employee findByid(Integer eid){
		return userService.findByid(eid);
	}

}
