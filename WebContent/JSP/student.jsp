<%@ page contentType="text/html; charset=utf-8" import="java.util.*" %>
<html>
<title>Student</title>
<style type="text/css">
			h1{
				text-align: center;
				line-height:20px;
				width: 700px;
				height: 100px;
				margin: 100px auto;
			}

</style>

<script language="JavaScript">
	function vaildate(f){
		var regex = /^\w{5,15}$/;	// 定义正则
		if(!(regex.test(f.examid.value))){
			alert("试卷号必须是 5~15位！");
			f.userid.focus();
			return false;
		}
		return true;
	}
</script>

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
			<h1><%=iter.next()%></h1></br>	<!-- 输出登录验证信息 -->
<%		
		}
	}
%>

<form action="TestServlet" method="post" onSubmit="return vaildate(this)">
	请输入试卷号：<input type="text" name="examid" placeholder="请输入试卷号" >
	<input type="submit" value="提交">
</form>

</body>

</html>