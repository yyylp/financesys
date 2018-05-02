package com.ylp.financesys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Department;
import com.ylp.financesys.biz.IDepartmentBiz;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	IDepartmentBiz departmentBiz;
	
	@RequestMapping("addDept")
	@ResponseBody
	public int addDept(Department department){
		return departmentBiz.addDept(department);
	}
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("rows") Integer pageSize,@RequestParam("page") Integer pageNo){
		return departmentBiz.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping("/deleteDept")
	@ResponseBody
	public int deleteDept(@RequestParam("dids") List<String> dids){
		return departmentBiz.deleteDept(dids);
	}
	
	@RequestMapping("/updateDept")
	@ResponseBody
	public int updateDept(Department department){
		return departmentBiz.updateDept(department);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(){
		Gson gson=new Gson();
		return gson.toJson(departmentBiz.findAll());
	}
}
