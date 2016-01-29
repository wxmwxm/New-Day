package common.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.utils.BeanUtils;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter----------");
		 HttpServletRequest servletRequest = (HttpServletRequest) request;
		 HttpServletResponse servletResponse = (HttpServletResponse) response;
		 HttpSession session = servletRequest.getSession();
		 Object obj = session.getAttribute("UserInfo");
		 if(BeanUtils.isObjectNotNull(obj)){
			 chain.doFilter(request, response);
		 }else{
			  // 跳转到登陆页面
			 System.out.println("----------");
			 request.setAttribute("msg","请先登录。");
			 servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.jsp");
		 }
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
