<%@ page contentType="text/html; charset=utf-8" import="java.util.*" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>myclass</title>
		<style type="text/css">
			#type {
				width: 300px;
				height: 400px;
				background:black;
				border: 1px solid cornflowerblue;
				margin: 0px auto;
				type-shadow: -10px 10px 10px black;
				border-radius:5px;
			}
			
			.type1 {
				width: 100%;
				height: 200px;
				text-align: center;
				margin: 150px auto;
				border-radius:5px;
			}
			
			.type2{
				width: 100%;
				height: 60px;
				background:gold;
				float:right;
				type-shadow: -5px 1px 10px black;
				margin:30px auto;
				border-radius:5px;
			}
			
			h4{
				text-align: center;
				line-height:20px;
				width: 200px;
				margin: 25px auto;
			}
			
			#a {
				background:gold;
			}
			#b {
				background:deepskyblue;
			}
			h2{
				text-align: center;
				line-height:20px;
			}
		</style>
	</head>
	<body>
	
<% 
	request.setCharacterEncoding("utf-8");	// 设置编码
%>
<% 
	List<String> info = (List<String>)request.getAttribute("info"); 	//取得属性
	if(info!=null){	// 判断是否有内容
		Iterator<String> iter = info.iterator();
		while(iter.hasNext()){
%>
			<h4><%=iter.next()%></h4>	<!-- 输出登录验证信息 -->
<%		
		}
	}
%>
	
	
		<div id="type">
			<div class="type2">
				<h2 style="color: white; font-family: '微软雅黑';">MyClass</h2>
			</div>
			
			<div class="type1">
				<form action="LoginServlet" method="post" onSubmit="return vaildate(this)">
					<input type="text" name="userid"  placeholder="用户名" style="width: 200px; height: 30px; border-radius:5px;" />
					<br />
					<br />
					<input type="password" name="userpass"  placeholder="请输入密码" style="width: 200px; height: 30px; border-radius:5px;" />
					<br />
					<br />
					<input type="submit" value= "登录" id="a" onmouseover="this.id='b'" onmouseout="this.id='a'" style="width: 200px; height: 30px; border-radius:5px;" />
					
					<br />
					<br />

				</form>
			</div>
		</div>
<script language="JavaScript">
	function vaildate(f){
		var regex = /^\w{5,15}$/;	// 定义正则
		if(!(regex.test(f.userid.value))){
			alert("用户名必须是 5~15位！");
			f.userid.focus();
			return false;
		}
		if(!(regex.test(f.userpass.value))){
			alert("密码必须是 5~15位！");
			f.userpass.focus();
			return false;
		}
		return true;
	}
</script>
	</body>


</html>

