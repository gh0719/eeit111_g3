package com.fund.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class OpenSessionInViewFilter implements Filter{
	
	private SessionFactory sessionFactory ;
	private WebApplicationContext context ;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		sessionFactory = (SessionFactory) context.getBean("sessionFactory") ;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("Transaction begin");
			chain.doFilter(request, response);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Transaction rollback");
			sessionFactory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}finally {
			System.out.println("Transaction closed");
		}
	}

	@Override
	public void destroy() {
		((ConfigurableApplicationContext)context).close();
	}
	
}
