<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>  
  <meta charset="utf-8" />
  <title>电影租赁系统</title>
  <meta name="happy" content="shiyaner" />
  <link rel="stylesheet" href="../css/main.css" type="text/css" />
  <script type="text/javascript">
  	function addCustomer(){
  		document.form.addCustomer.action="${pageContext.request.contextPath }/customer/getAllAddress.action";
		document.form.addCustomer.submit();
  	}
  	function check(){
  		if(confirm("删除吗？")){
  			return true;
  		}else{
  			return false;
  		}
  	}
  </script>
  
 </head>


<body>
 	<div id="header">
 		<div><h2 class="logo">电影租赁系统</h2><div class="home">${username}<a href="${pageContext.request.contextPath }/customer/logout.action">退出</a></div></div>
 	</div>
	<div id="LeftIndext">
		<div class="menu">
			<ul>
            <li><a href="${pageContext.request.contextPath }/customer/findAllCutomer.action">Customer管理</a>  
              
            </li>
            <li>Film管理    
            </li>
            
  			</ul>
		</div>
	</div>
	<div id="RightIndext">
		<div>
        <h3>客户管理</h3>
        <form name="addCustomer" action="${pageContext.request.contextPath }/customer/getAllAddress.action">
        	<button name="addCustomer"  onclick="addCustomer()">新建</button>
        </form>
		<form >
		 <div>客户列表</div>	
	      <table width="90%" border="1">
		      <tr class="header">
		      <td>编辑</td>
		      <td>删除</td>
		         <td>Customer_id</td>
		        <td>First_name</td>
		        <td>Last_name</td>
		        <td>Address</td>
		        <td>Email</td>
                <td>Last_update</td>
	        </tr>
		   
	        <%--循环输出考勤信息 --%>
	        <c:forEach var="customer" items="${requestScope.customerList}" varStatus="stut">
		      <tr>
			      <td><a href="${pageContext.request.contextPath }/customer/editCustomer.action?id=${customer.customer_id}">编辑</a></td>
			      <td><a onclick="return check()" href="${pageContext.request.contextPath }/customer/deleteCustomer.action?id=${customer.customer_id}">删除</a></td>
		        <td>${customer.customer_id}</td>
		        <td>${customer.first_name}</td>
		        <td>${customer.last_name}</td>
		        <td>${customer.address_name}</td>
		        <td>${customer.email}</td>
		        <td>${customer.last_update}</td>
	        </tr>
	        </c:forEach>
	       
	      </table>
	       <%
        	Object object=request.getAttribute("msg");
       		 if(object!=null){
        		String msg=(String)object;
        		out.print(msg);
        	}
        %>
	      </form>
		</div>
	</div>
	
</body>
</html>