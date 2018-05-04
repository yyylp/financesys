<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="../css/login.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
</head>
<body>
<div class="page">
	<div class="title">财务报销系统</div>
	<div class="loginwarrp">
		<div class="logo">用户登陆</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post">
			<ul>
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="username" name="UserName" class="login_input" >
                    <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="password" class="login_input" >
                    <span id="password-msg" class="error"></span>
				</li>
				<li class="login-sub">
					<input type="button" name="button" value="登录" onclick="login()"/>
                    <input type="reset" name="Reset" value="重置" />
				</li> 
			</ul>                     
           </form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function login(){
		var name=$("#username").val();
		var pwd=$("#password").val();
		$.post("../emp/login",{name:name,pwd:pwd},function(data){
			if(data>0){
				window.location.href="index.html";
			}else{
				alert("用户名或密码错误，请重新输入");
			}
		},'text');
	}
</script>
</html>
