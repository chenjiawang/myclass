<%@ page contentType="text/html; charset=utf-8" import="java.util.*" %>
<html>

<style type="text/css">
			h1{
				text-align: center;
				line-height:20px;
				width: 700px;
				height: 400px;
				margin: 100px auto;
			}

</style>
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
			<h1><%=iter.next()%></h1>	<!-- 输出登录验证信息 -->
<%		
		}
	}
%>


</body>

</html>