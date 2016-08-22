package com.yuxiaoli.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter{

	private FilterConfig filterConfig;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//判断session是否存在
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String userName=(String) httpRequest.getSession().getAttribute("userName");
		if(userName==null){
			//没有登录，session对象为空
			//跳到登录界面
			httpResponse.sendRedirect("login.jsp");
		}else{
			filterChain.doFilter(request, response); //向下传递
		}
	}

	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=fc;
	}

}
