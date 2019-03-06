package com.sefamertkaya.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sefamertkaya.entity.User;

@Component
@Scope("session")
public class LoginFilter implements Filter {

	public void destroy() {

		// iþlem bittiðinde çalýþýcak

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// request ve response iþlemlerinde çalýþýcak method bu.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (req.getRequestURI().contains("login")) {
			chain.doFilter(request, response);
			return;
		}

		User user = (User) req.getSession().getAttribute("user");

		if (user != null) {

			System.out.println(req.getRequestURI());
			chain.doFilter(request, response);
			return;
		} else {
			res.sendRedirect("http://localhost:8080/yazilimsozluk/girisyap");

		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// filter bþaladýðýnda çalýþcak.
	}

}
