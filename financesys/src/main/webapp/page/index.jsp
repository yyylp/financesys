<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="../easyui/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/css/wu.css" />
<link rel="stylesheet" type="text/css" href="../easyui/css/icon.css" />
<script type="text/javascript" src="../easyui/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/js/easyui-lang-zh_CN.js"></script>
<style>
	#crpwd p{
		line-height: 20px;
		font-size:20px;
		margin-left:150px;
		
	}
</style>
</head>
<body class="easyui-layout">
	<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1>财务报销系统</h1>
        </div>
        <div class="wu-header-right">
        	<p><strong class="easyui-tooltip" title="2条未读消息" id="loginAdmin"></strong>，欢迎您！</p>
            <p><a href="#">网站首页</a>|<a href="#">支持论坛</a>|<a href="javascript:correctpwd()">修改密码</a>|<a href="javascript:exit()">安全退出</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<!-- <div class="easyui-accordion" data-options="border:false,fit:true"> 
        </div> -->
	<ul id="tt"></ul>  

    </div>	
    <!-- end of sidebar -->    
    <!-- begin of main -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="首页" data-options="href:'',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
        </div>
    </div> 
    <div id="crpwd" style="margin-top:30px;">
    	<p><label>&nbsp;&nbsp;&nbsp;旧密码：</label><input type="password" id="oldpwd"/></p>
    	<p><label>&nbsp;&nbsp;&nbsp;新密码：</label><input type="password" id="newpwd"/></p>
    	<p><label>确认密码：</label><input type="password" id="repeatpwd"/></p>
    	<p><a id="btn" href="javascript:changepwd()" class="easyui-linkbutton" style="margin-left:80px;">修改</a>  
    	</p>
    </div> 
    <!-- end of main --> 
    <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy; 2018 杨丽萍 14软件工程01班
    </div>
    <!-- end of footer -->  
    <script type="text/javascript">

		/**
		* Name 选项卡初始化
		*/
		$('#wu-tabs').tabs({
			tools:[{
				iconCls:'icon-reload',
				border:false,
				handler:function(){
					$('#wu-datagrid').datagrid('reload');
				}
			}]
		});
			
		
		/**
		* Name 添加菜单选项
		* Param title 名称
		* Param href 链接
		* Param iconCls 图标样式
		* Param iframe 链接跳转方式（true为iframe，false为href）
		*/	
		function addTab(title, href, iconCls, iframe){
			var tabPanel = $('#wu-tabs');
			if(!tabPanel.tabs('exists',title)){
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
				if(iframe){
					tabPanel.tabs('add',{
						title:title,
						content:content,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
				else{
					tabPanel.tabs('add',{
						title:title,
						href:href,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
			}
			else
			{
				tabPanel.tabs('select',title);
			}
		}
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		} 
		$.post("../menu/findAll",{},function(data){
			console.log(data);
			$('#tt').tree({   
			    data:data,
			    onClick: function(node){
			    	if(node.attributes.url!=""){		    		
						addTab(node.text,node.attributes.url,"",true);
			    	}
				}
			}); 
		},'json');
	     
	</script>
	
</body>
</html>
