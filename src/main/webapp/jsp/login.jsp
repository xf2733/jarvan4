<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang = "zh">
<head>
	<meta charset="utf-8"/>
	<meta name="happy" content="shiyan2"/>
	<title>电影租赁系统</title>
	<link rel="stylesheet" href="../css/main.css" type="text/css"/>
	<script type="text/javascript">
		function check(){
			
			if(document.loginForm.first_name.value==""){
    			alert("请输入用户名！");
    			document.loginForm.first_name.focus();
    			return false;
    		}else if(document.loginForm.password.value==""){
    			alert("请输入密码！");
    			document.loginForm.password.focus();
    			return false;
    		}else{
    			document.loginForm.action="${pageContext.request.contextPath }/customer/login.action";
    			document.loginForm.submit();
    		}
    		
		}
	</script>
</head>
<body >
	<div>11003&nbsp徐枫</div>
	<div id="login">
		<form name="loginForm" action="${pageContext.request.contextPath }/customer/login.action" method="post">
			<fieldset>
				<legend>电影租赁系统</legend>
				<div class="error"></div>
				<input type="text" name="first_name" placeholder="用户名" ><br>
				<input type="password" name="password" placeholder="密码"><br>
				<input type="button" value="登录" class="btn" onclick="return check()">
		<%
        	Object object=request.getAttribute("msg");
       		 if(object!=null){
        		String msg=(String)object;
        		//String massage=new String(msg.getBytes("iso8859-1"),"utf-8");
        		out.print(msg);
        	}
        %>
			</fieldset>
		</form>
	</div>
</body>
</html>