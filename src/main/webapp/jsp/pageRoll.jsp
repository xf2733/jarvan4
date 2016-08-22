<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pageRoll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form action="${param.action}" name="pageRollForm" id="pageRollForm" method="post">
          当前是第${requestScope.pageRoll.currPage}页|
          共${requestScope.pageRoll.pageCount}页|
          共${requestScope.pageRoll.totalCount}条记录
          
          <input type="hidden" name="currPage" id="currPage" value="${requestScope.pageRoll.currPage}">
          <input type="hidden" name="pageCount" id="pageCount" value="${requestScope.pageRoll.pageCount}">
          
          <input type="submit" value="首页" onclick="return firstPage()">
          <input type="submit" value="上一页" onclick="return prevPage()">
          <input type="submit" value="下一页" onclick="return nextPage()">
          <input type="submit" value="尾页" onclick="return lastPage()">
         
     </form>
    
    <script type="text/javascript">
    	//首页
    	function firstPage(){
    	
    	  var _currPage=document.getElementById("currPage").value;
    	  if(_currPage==1){
    	     alert("已经是第一页了！");
    	     return false;
    	  }
    	  document.getElementById("currPage").value=1;
    	 	return true;
    	}
    	
    	function prevPage(){
    		var _currPage=document.getElementById("currPage").value;
    	  if(_currPage==1){
    	     alert("已经是第一页了！");
    	     return false;
    	  }
    	 document.getElementById("currPage").value=--_currPage;
    	  return true;
    	}
    	
    	function nextPage(){
    		var _currPage=document.getElementById("currPage").value;
    		var _pageCount=document.getElementById("pageCount").value;
    		if(_currPage==_pageCount){
    		    alert("已经是最后一页了！");
    	        return false;
    		}
    		document.getElementById("currPage").value=++_currPage;
    	 return true;
    	}
    	
    	function lastPage(){
    		var _currPage=document.getElementById("currPage").value;
    		var _pageCount=document.getElementById("pageCount").value;
    		if(_currPage==_pageCount){
    		    alert("已经是最后一页了！");
    	        return false;
    		}
    		document.getElementById("currPage").value=_pageCount;
    		return true;
    	}
    	
    	
    </script>
    
  </body>
</html>
