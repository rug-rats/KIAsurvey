package com.sourceit.survey.controller.common;

import org.apache.commons.lang.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServletHandler extends CommonServletHandler {
	private static final long serialVersionUID = 4544737546336836686L;
	
	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {

		String status = String.valueOf(request.getAttribute("javax.servlet.error.status_code"));

		String errorMessage;
		Exception exception;
		String fullStackTrace = null;

		if("404".equals(status.trim())) {
			
			errorMessage = "Page not found";
		} else {
			
			errorMessage = String.valueOf(request.getAttribute("javax.servlet.error.message"));
			exception = (Exception)request.getAttribute("javax.servlet.error.exception") ;
			if(exception != null) {
				
				errorMessage = exception.getMessage();
				fullStackTrace = ExceptionUtils.getFullStackTrace(exception).replace('\t',' ').trim();
			}
		}

		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("fullStackTrace", fullStackTrace);
		forwardToJSP("error", request, response);
	}
}
