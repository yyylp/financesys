package com.ylp.financesys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Ftype;
import com.ylp.financesys.biz.IFtypeBiz;

@Controller
@RequestMapping("/ftype")
public class FtypeController {
	@Autowired
	IFtypeBiz ftypeBiz;
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize){
		return ftypeBiz.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping("/addFtype")
	@ResponseBody
	public int addftype(Ftype ftype){
		return ftypeBiz.addFtype(ftype);
	}
	
	@RequestMapping("/deleteFtype")
	@ResponseBody
	public int deleteftype(@RequestParam("fids") List<String> fids){
		System.out.println(fids);
		if (fids!=null&&fids.size()>0) {			
			return ftypeBiz.deleteFtype(fids);
		}
		return 0;
	}
	
	@RequestMapping("/updateFtype")
	@ResponseBody
	public int updateftype(Ftype ftype){
		return ftypeBiz.updateFtype(ftype);
	}
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(){
		Gson gson=new Gson();
		return gson.toJson(ftypeBiz.findAll());
	}
}
