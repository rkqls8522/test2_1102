package green.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

public class CharacterEncodingFilter implements Filter {
	FilterConfig config; //¸â¹öº¯¼ö 

	public void destroy() {
		System.out.println("CharacterEncodingFilter destroy ok");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CharacterEncodingFilter doFilter ok");
		request.setCharacterEncoding(config.getInitParameter("encoding"));//web.xml¿¡¼­ °¡Á®¿È 
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("CharacterEncodingFilter init ok");
		this.config =config;
	}

}
