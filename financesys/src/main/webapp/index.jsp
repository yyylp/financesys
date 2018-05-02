<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
</head>
<body>
	
</body>
<script type="text/javascript">
	/* $.post("addRole",{sname:"管理员"},function(data){
		console.log(data);
	},'text'); */
	$.post("menu/findAll",{},function(data){
		$.each(data,function(index,item){
			console.log(item);
		});
	},'json');
</script>
</html>