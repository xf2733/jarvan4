package com.yuxiaoli.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*//��ȡ�����url
		String url = request.getRequestURI();
		//�ж�url�Ƿ��ǹ��� ��ַ��ʵ��ʹ��ʱ������ ��ַ���������ļ��У�
		//���﹫����ַ�ǵ�½�ύ�ĵ�ַ
		if(url.indexOf("login.action")>=0){
			//������е�½�ύ������
			return true;
		}*/

		//�ж�session
		HttpSession session  = request.getSession();
		//��session��ȡ���û������Ϣ
		String username = (String) session.getAttribute("username");

		if(username != null){
			//��ݴ��ڣ�����
			return true;
		}

		//ִ�������ʾ�û������Ҫ��֤����ת��½ҳ��
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
