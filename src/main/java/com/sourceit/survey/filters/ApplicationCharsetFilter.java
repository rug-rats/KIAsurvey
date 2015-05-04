package com.sourceit.survey.filters;

import org.apache.commons.lang.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationCharsetFilter extends AbstractApplicationFilter {
	private String encoding = "UTF-8";
	
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		
		String encoding = filterconfig.getInitParameter("encoding");
		
		if(StringUtils.isNotBlank(encoding)) {
			
			this.encoding = encoding;
		}
	}

	@Override
	public void doFilter(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain)
			throws IOException, ServletException {
		
		httpRequest.setCharacterEncoding(encoding);
		chain.doFilter(httpRequest, httpResponse);
		httpResponse.setCharacterEncoding(encoding);
		
	}
}
