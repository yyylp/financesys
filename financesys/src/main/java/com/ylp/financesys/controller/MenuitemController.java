package com.ylp.financesys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Menuitem;
import com.ylp.financesys.bean.Menutype;
import com.ylp.financesys.biz.IMenuitemBiz;
import com.ylp.financesys.biz.IMenutypeBiz;

@Controller
@RequestMapping("/menu")
public class MenuitemController {
	@Autowired
	private IMenuitemBiz menuitemBiz;
	@Autowired
	private IMenutypeBiz menutypeBiz;

	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll(){
		/*
		 *  id:节点id,这个很重要到加载远程服务器数据 which is important to load remote data 
			text: 显示的节点文本 
			state: 节点状态, 'open' 或者 'closed', 默认是 'open'. 当设置为 'closed', 节点所有的子节点将从远程服务器站点加载 
			checked: 指明检查节点是否选中. 
			attributes: 可以添加到节点的自定义属性 
			children: 一个节点数组,定义一些子节点
		 */
		int id=0;
		String state="closed";
		String checked="false";
		List<Map<String, Object>> nodes=new ArrayList<Map<String,Object>>();
		List<Menutype> menutypes=menutypeBiz.findAll();
		List<Menuitem> menuitems=menuitemBiz.findAll();
		if (menutypes!=null&&menutypes.size()>0) {
			for (Menutype menutype : menutypes) {
				Map<String, Object> node=new HashMap<String, Object>();
				node.put("id", ++id);
				node.put("text", menutype.getMtname());
				node.put("state", state);
				node.put("ckecked", checked);
				List<Map<String, Object>> chidren=new ArrayList<Map<String,Object>>();
				if (menuitems!=null&&menuitems.size()>0) {
					int i=0;
					for (Menuitem menuitem : menuitems) {
						if (menuitem.getMtid().equals(menutype.getMtid())) {
							Map<String, Object> child=new HashMap<String, Object>();
							child.put("id", String.valueOf(id)+String.valueOf(++i));
							child.put("text", menuitem.getMname());
							child.put("ckecked", checked);
							Map<String, Object> attr=new HashMap<String, Object>();
							attr.put("url", menuitem.getAttr()+".html");
							child.put("attributes", attr);
							chidren.add(child);
						}
					}
				}
				node.put("children", chidren);
				nodes.add(node);
			}
		}
		Gson gson=new Gson();
		return gson.toJson(nodes);
	}
}
