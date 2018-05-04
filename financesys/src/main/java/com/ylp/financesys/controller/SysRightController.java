package com.ylp.financesys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylp.financesys.bean.Sysright;
import com.ylp.financesys.biz.ISysrightBiz;
import com.ylp.financesys.util.StringUtil;

@Controller
@RequestMapping("/right")
public class SysRightController {
	@Autowired
	ISysrightBiz sysrightBiz;

	@RequestMapping("/addRight")
	@ResponseBody
	public int addRight(String sid,String mid){
		System.out.println(sid);
		System.out.println(mid);
		String[] str=mid.split(",");
		List<String> mids=new ArrayList<String>();
		List<String> dels=new ArrayList<String>();
		if (str.length>0) {
			for (int i = 0; i < str.length; i++) {
				Sysright sysright=new Sysright();
				sysright.setMid(str[i]);
				sysright.setSid(sid);
				System.out.println(sysright.toString());
				if (sysrightBiz.findBySidMid(sysright)==null) {
					mids.add(str[i]);					
				}
				dels.add(str[i]);
			}
		}

		Map<String, Object> params=new HashMap<String, Object>();
		params.put("sid", sid);
		params.put("dels", dels);
		System.out.println(sysrightBiz.deleteBySid(params));
		if (mids.size()>0&&mids!=null) {
			params.put("mids", mids);
			return sysrightBiz.addRight(params);
		}
		System.out.println(params);
		return 0;
	}
}
