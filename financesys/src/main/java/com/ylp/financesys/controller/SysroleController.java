package com.ylp.financesys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Department;
import com.ylp.financesys.bean.Sysrole;
import com.ylp.financesys.biz.ISysroleBiz;

@Controller()
@RequestMapping("/role")
public class SysroleController {
	@Autowired
	private ISysroleBiz sysroleBiz;
	
	@RequestMapping("/addRole")
	@ResponseBody
	public int addRole(Sysrole sysrole) {
		return sysroleBiz.addRole(sysrole);
	}
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("rows") Integer pageSize,@RequestParam("page") Integer pageNo){
		return sysroleBiz.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public int delete(@RequestParam("sids") List<String> sids){
		System.out.println(sids);
		return sysroleBiz.deleteRole(sids);
	}
	@RequestMapping("/updateRole")
	@ResponseBody
	public int update(Sysrole sysrole){
		return sysroleBiz.updateRole(sysrole);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(){
		Gson gson=new Gson();
		return gson.toJson(sysroleBiz.findAll());
	}
	
	@RequestMapping("/findByTree")
	@ResponseBody
	public String findByTree(){
		List<Map<String, Object>> nodes=new ArrayList<Map<String,Object>>();
		List<Sysrole> sysroles=sysroleBiz.findAll();
		for(Sysrole sysrole:sysroles){
			Map<String, Object> roles=new HashMap<String, Object>();
			roles.put("id", sysrole.getSid());
			roles.put("text",sysrole.getSname());
			nodes.add(roles);
		}
		Gson gson=new Gson();
		return gson.toJson(nodes);
	}
}
