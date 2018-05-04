package com.ylp.financesys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ylp.financesys.bean.Employer;
import com.ylp.financesys.bean.Menuitem;
import com.ylp.financesys.bean.Menutype;
import com.ylp.financesys.biz.IMenuitemBiz;
import com.ylp.financesys.biz.IMenutypeBiz;
import com.ylp.financesys.biz.ISysrightBiz;
import com.ylp.financesys.util.StringUtil;

@Controller
@RequestMapping("/menu")
public class MenuitemController {
	@Autowired
	private IMenuitemBiz menuitemBiz;
	@Autowired
	private IMenutypeBiz menutypeBiz;
	@Autowired
	private ISysrightBiz sysrightBiz;

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
				node.put("id", menutype.getMtid());
				node.put("text", menutype.getMtname());
				node.put("state", state);
				node.put("ckecked", true);
				List<Map<String, Object>> chidren=new ArrayList<Map<String,Object>>();
				if (menuitems!=null&&menuitems.size()>0) {
					int i=0;
					for (Menuitem menuitem : menuitems) {
						if (menuitem.getMtid().equals(menutype.getMtid())) {
							Map<String, Object> child=new HashMap<String, Object>();
							child.put("id", menuitem.getMid());
							child.put("text", menuitem.getMname());
							child.put("ckecked", true);
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
		System.out.println(nodes);
		Gson gson=new Gson();
		return gson.toJson(nodes);
	}
	/**
	 * 根据当前登录用户获取菜单
	 * @param session
	 * @return
	 */
	@RequestMapping("/findBySid")
	@ResponseBody
	public String findBySid(HttpSession session){
		/*
		 *  id:节点id,这个很重要到加载远程服务器数据 which is important to load remote data 
			text: 显示的节点文本 
			state: 节点状态, 'open' 或者 'closed', 默认是 'open'. 当设置为 'closed', 节点所有的子节点将从远程服务器站点加载 
			checked: 指明检查节点是否选中. 
			attributes: 可以添加到节点的自定义属性 
			children: 一个节点数组,定义一些子节点
		 */
		List<Map<String, Object>> nodes=new ArrayList<Map<String,Object>>();
		//获取当前登录用户
		Employer emp=(Employer) session.getAttribute("currentLogin");
		if (emp!=null) {
			String eid=emp.getEid();
			String sid=emp.getsid();
			List<Menutype> menutypes=menutypeBiz.findAll();
			List<Menuitem> menuitems=menuitemBiz.findBySid(sid);
			
			if (menutypes!=null&&menutypes.size()>0) {
				for (Menutype menutype : menutypes) {
					Map<String, Object> node=new HashMap<String, Object>();
					node.put("id", menutype.getMtid());
					node.put("text", menutype.getMtname());
					node.put("state", "open");
					node.put("ckecked", true);
					List<Map<String, Object>> chidren=new ArrayList<Map<String,Object>>();
					if (menuitems!=null&&menuitems.size()>0) {
						for (Menuitem menuitem : menuitems) {
							if (menuitem.getMtid().equals(menutype.getMtid())) {
								Map<String, Object> child=new HashMap<String, Object>();
								child.put("id", menuitem.getMid());
								child.put("text", menuitem.getMname());
								child.put("ckecked", true);
								Map<String, Object> attr=new HashMap<String, Object>();
								attr.put("url", menuitem.getAttr()+".html");
								child.put("attributes", attr);
								chidren.add(child);
								node.put("children", chidren);
							}
						}
					}
					if (node.get("children")!=null) {						
						nodes.add(node);
					}
				}
			}
			System.out.println(nodes);
			Gson gson=new Gson();
			return gson.toJson(nodes);
		}
		return null;
	}
	/**
	 * 分页查询所有菜单项
	 * @param session
	 * @return
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(@RequestParam("page") Integer pageNo,@RequestParam("rows") Integer pageSize,HttpSession session){
		Map<String, Object> results=menuitemBiz.findByPage(pageNo, pageSize);
		List<Menuitem> menuitems=(List<Menuitem>) results.get("rows");
		//获取当前登录用户
		Employer emp=(Employer) session.getAttribute("currentLogin");
		if (emp!=null) {
			String sid=emp.getsid();
			List<String> rightList=sysrightBiz.findBySid(sid);
			for (String right : rightList) {
				for (Menuitem menuitem : menuitems) {
					if (menuitem.getMid().equals(right)) {
						menuitem.setFlag(1);
					}
				}
			}
		}
		System.out.println(menuitems);
		results.put("rows", menuitems);
		System.out.println(results);
		return results;
	}
}
