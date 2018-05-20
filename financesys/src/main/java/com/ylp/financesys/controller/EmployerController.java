package com.ylp.financesys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylp.financesys.bean.Employer;
import com.ylp.financesys.biz.IEmployerBiz;
import com.ylp.financesys.util.StringUtil;

@Controller
@RequestMapping("/emp")
public class EmployerController {
	@Autowired
	IEmployerBiz employerBiz;
	
	@RequestMapping("/addEmp")
	@ResponseBody
	public int addEmp(Employer employer){
		System.out.println(employer);
		return employerBiz.addEmp(employer);
	}
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("rows") Integer pageSize,@RequestParam("page") Integer pageNo){
		System.out.println(employerBiz.findByPage(pageNo, pageSize));
		return employerBiz.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping("/deleteEmp")
	@ResponseBody
	public int deleteEmp(@RequestParam("eids") List<String> eids){
		return employerBiz.deleteEmp(eids);
	}
	
	@RequestMapping("/updateEmp")
	@ResponseBody
	public int updateEmp(Employer employer){
		return employerBiz.updateEmp(employer);
	}
	@RequestMapping("/findByCondition")
	@ResponseBody
	public Map<String, Object> findByCondition(@RequestParam("role") String role,@RequestParam("ename") String ename,@RequestParam("dept") String dept,@RequestParam("tel") String tel,@RequestParam("rows") Integer pageSize,@RequestParam("page") Integer pageNo){
		Map<String, Object> map=new HashMap<String, Object>();
		if (!StringUtil.isNull(ename)) {			
			map.put("ename", ename);
		}
		if (!StringUtil.isNull(dept)) {			
			map.put("dept", dept);
		}
		if (!StringUtil.isNull(tel)) {			
			map.put("tel", tel);
		}
		if (!StringUtil.isNull(role)) {			
			map.put("sname", role);
		}
		System.out.println("yes");
		System.out.println(map);
		return employerBiz.findByConditon(map, pageNo, pageSize);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(@RequestParam("name") String name,@RequestParam("pwd") String pwd,HttpSession session){
		Employer employer=employerBiz.login(name, pwd);
		if (employer!=null) {			
			session.setAttribute("currentLogin",employer);
			System.out.println(employer);
			return 1;
		}
		return 0;
	}
}
