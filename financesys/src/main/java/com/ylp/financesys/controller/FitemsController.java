package com.ylp.financesys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Fitems;
import com.ylp.financesys.biz.IFitemsBiz;

@Controller
@RequestMapping("/fitems")
public class FitemsController {
	@Autowired
	IFitemsBiz fitemsBiz;
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize){
		return fitemsBiz.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping("/addFitems")
	@ResponseBody
	public int addFitems(Fitems fitems){
		return fitemsBiz.addFitems(fitems);
	}
	
	@RequestMapping("/delelteFitems")
	@ResponseBody
	public int deleteFitems(@RequestParam("imids") List<String> imids){
		return fitemsBiz.deleteFitems(imids);
	}
	
	@RequestMapping("/updateFitems")
	@ResponseBody
	public int updateFitems(Fitems fitems){
		return fitemsBiz.updateFitems(fitems);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(){
		Gson gson=new Gson();
		return gson.toJson(fitemsBiz.findAll());
	}
}
