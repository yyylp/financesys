package com.ylp.financesys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylp.financesys.bean.Admin;
import com.ylp.financesys.biz.IAdminBiz;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	IAdminBiz adminBiz;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(@RequestParam("name") String name,@RequestParam("pwd") String pwd,HttpSession session) {
		Admin admin=adminBiz.login(name, pwd);
		if (admin!=null) {
			session.setAttribute("currentLogin", admin);
			session.setAttribute("currentRole", "admin");
			System.out.println(admin);
			return 1;
		}
		return 0;
	}
}
