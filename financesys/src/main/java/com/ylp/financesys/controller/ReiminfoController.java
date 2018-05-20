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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Employer;
import com.ylp.financesys.bean.Reiminfo;
import com.ylp.financesys.biz.IEmployerBiz;
import com.ylp.financesys.biz.IReiminfoBiz;
import com.ylp.financesys.util.FileUpload;
import com.ylp.financesys.util.StringUtil;

@Controller
@RequestMapping("/reiminfo")
public class ReiminfoController {
	@Autowired
	IReiminfoBiz reiminfoBiz;
	@Autowired 
	IEmployerBiz employerBiz;

	@RequestMapping("/addReim")
	@ResponseBody
	public int addReim(Reiminfo reiminfo,@RequestParam("selectPic") MultipartFile file,HttpServletRequest request,HttpSession session){
		//获取当前登录用户
		Employer emp=(Employer) session.getAttribute("currentLogin");
		if (emp!=null) {
			String eid=emp.getEid();
			String did=emp.getDid();
			reiminfo.setEid(eid);
			FileUpload fileUpload=new FileUpload();
			Map<String, String> map=fileUpload.upload(request, file, "/photos/");
			reiminfo.setProof("");
			if (map.get("upload")!=null) {
				reiminfo.setProof(map.get("upload"));
			}			reiminfo.setRstatus("0");//报销状态 0已申请
			//获取该员工的部门经理
			List<String> deptManager=employerBiz.findDeptManager(did);
			if (deptManager!=null&&deptManager.size()>0) {
				String str="";
				for (String dept : deptManager) {
					str+=dept+",";
				}
				reiminfo.setDeptmanager(str.substring(0, str.lastIndexOf(",")));
			}
			//获取出纳
			List<String> casher=employerBiz.findByRole("出纳");
			if (casher!=null&&casher.size()>0) {
				String str="";
				for (String cash : casher) {
					str+=cash+",";
				}
				reiminfo.setCashier(str.substring(0, str.lastIndexOf(",")));
			}			//获取财务
			List<String> financer=employerBiz.findByRole("财务");
			if (financer!=null&&financer.size()>0) {
				String str="";
				for (String fin : financer) {
					str+=fin+",";
				}
				reiminfo.setFinancer(str.substring(0, str.lastIndexOf(",")));
			}			
			//获取总经理
			List<String> topmanager=employerBiz.findByRole("总经理");
			if (topmanager!=null&&topmanager.size()>0) {
				String str="";
				for (String top : topmanager) {
					str+=top+",";
				}
				reiminfo.setTopmanager(str.substring(0, str.lastIndexOf(",")));
			}	
			System.out.println(reiminfo);
			return reiminfoBiz.addReiminfo(reiminfo);
		}
		return 0;
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public String findByPage(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize){
		Gson gson=new Gson();
		System.out.println(reiminfoBiz.findByPage(pageNo, pageSize));
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
	@RequestMapping("/findByCondition")
	@ResponseBody
	public Map<String, Object> findByCondition(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize,
			@RequestParam("imid") String imid,@RequestParam("status") String status,@RequestParam("date") String date,
			@RequestParam("startprice") String startprice,@RequestParam("endprice") String endprice){
		Map<String, Object> map=new HashMap<String, Object>();
		if (!StringUtil.isNull(imid)) {			
			map.put("imid", imid);
		}
		if (!StringUtil.isNull(status)) {			
			map.put("status", status);
		}
		if (!StringUtil.isNull(date)) {			
			map.put("date", date);
		}
		if (!StringUtil.isNull(startprice)) {			
			map.put("startprice", Double.parseDouble(startprice));
		}
		if (!StringUtil.isNull(endprice)) {			
			map.put("endprice", Double.parseDouble(endprice));
		}
		System.out.println(map);
		return reiminfoBiz.findByCondition(pageNo, pageSize, map);
	}
	
	@RequestMapping("/editReim")
	@ResponseBody
	public int editReim(@RequestParam("rid") String rid,HttpSession session){
		if (!StringUtil.isNull(rid)) {
			session.setAttribute("currentEditReim", rid);
			return 1;
		}
		return 0;
	}
	@RequestMapping("/findByRid")
	@ResponseBody
	public String findByRid(HttpSession session){
		String rid=(String) session.getAttribute("currentEditReim");
		if (!StringUtil.isNull(rid)) {
			Gson gson=new Gson();
			System.out.println(reiminfoBiz.findByRid(rid));
			return gson.toJson(reiminfoBiz.findByRid(rid));
		}
		return null;
	}
	
	@RequestMapping("/saveReim")
	@ResponseBody
	public int saveReim(Reiminfo reiminfo,@RequestParam("edit_selectPic") MultipartFile file,HttpServletRequest request,HttpSession session){
		FileUpload fileUpload=new FileUpload();
		Map<String, String> map=fileUpload.upload(request, file, "/photos/");
		reiminfo.setProof("");
		if (map.get("upload")!=null) {
			reiminfo.setProof(map.get("upload"));
		}
		System.out.println(reiminfo);
		return reiminfoBiz.updateReiminfo(reiminfo);
	}
	@RequestMapping("/checkReim")
	@ResponseBody
	public int checkReim(@RequestParam("rid") String rid,@RequestParam("status") String status){
		if (!StringUtil.isNull(rid,status)) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("rid", rid);
			params.put("rstatus", Integer.parseInt(status)+1);
			System.out.println(params);
			return reiminfoBiz.checkReim(params);
		}
		return 0;
	}
	@RequestMapping("/uncheckReim")
	@ResponseBody
	public int uncheckReim(@RequestParam("rid") String rid){
		if (!StringUtil.isNull(rid)) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("rid", rid);
			params.put("rstatus", "-1");
			System.out.println(params);
			return reiminfoBiz.checkReim(params);
		}
		return 0;
	}
}
