package com.ylp.financesys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Reiminfo;
import com.ylp.financesys.biz.IReiminfoBiz;
import com.ylp.financesys.util.FileUpload;

@Controller
@RequestMapping("/reiminfo")
public class ReiminfoController {
	@Autowired
	IReiminfoBiz reiminfoBiz;
	
	@RequestMapping("/addReim")
	@ResponseBody
	public int addReim(Reiminfo reiminfo,@RequestParam("selectPic") MultipartFile file,HttpServletRequest request){
		FileUpload fileUpload=new FileUpload();
		Map<String, String> map=fileUpload.upload(request, file, "/photos/");
		reiminfo.setProof(map.get("upload"));
		System.out.println(reiminfo);
		return 0;
		//return reiminfoBiz.addReiminfo(reiminfo);
	}
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public String findByPage(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize){
		Gson gson=new Gson();
		return gson.toJson(reiminfoBiz.findByPage(pageNo, pageSize));
	}
	@RequestMapping("/findByEmp")
	@ResponseBody
	public String findByEmp(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize,@RequestParam("eid") String eid){
		Gson gson=new Gson();
		return gson.toJson(reiminfoBiz.findByEmp(pageNo, pageSize,eid));
	}
	
	@RequestMapping("/deleteReim")
	@ResponseBody
	public int deleteReim(@RequestParam("rids") List<String> rids){
		return reiminfoBiz.deleteReiminfo(rids);
	}
	
	@RequestMapping("/updateReim")
	@ResponseBody
	public int updateReim(Reiminfo reiminfo){
		return reiminfoBiz.updateReiminfo(reiminfo);
	}
}
