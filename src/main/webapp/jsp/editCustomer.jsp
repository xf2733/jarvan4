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
 </head>
  
  <body>
    <div id="header">
 		<div><h2 class="logo">电影租赁系统</h2><div class="home">${username}<a href="${pageContext.request.contextPath }/customer/logout.action">退出</a></div></div>
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
        <h3>修改Customer</h3>
        <form action="${pageContext.request.contextPath }/customer/editCustomerSubmit.action" method="post">
				<fieldset>
					<legend>基本信息</legend>
					<input type="hidden" name="customer_id" value="${customer.customer_id}">
		First_name:<input type="text" name="first_name" placeholder="First_name" value="${customer.first_name} "><br>
        Last_name:<input type="text" name="last_name" placeholder="Last_name" value="${customer.last_name}"><br>
        Email:<input type="text" name="email" placeholder="Email" value="${customer.email}"><br>
        Address:

        <select name="address_id">
        	<c:forEach var="addresses" items="${requestScope.addressList}">
				<option value="${addresses.address_id}">${addresses.address}</option>
		</c:forEach>
        </select>
        <input type="submit" value="修改" class="btn"><br> 
        <%
        	Object object=request.getAttribute("msg");
       		 if(object!=null){
        		String msg=(String)object;
        		out.print(msg);
        	}
        %>
				</fieldset>
			</form>
		</div>
	</div>
  </body>
</html>
