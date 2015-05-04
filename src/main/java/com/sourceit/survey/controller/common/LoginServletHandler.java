package com.sourceit.survey.controller.common;

import com.sourceit.survey.exceptions.InvalidDataException;
import com.sourceit.survey.model.Account;
import com.sourceit.survey.utils.CommonConstants;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginServletHandler extends CommonServletHandler implements CommonConstants {
	private static final long serialVersionUID = 4544737546336836686L;

	private final Map<Integer, String> homePages = new HashMap<Integer, String>() {
		{
			put(ROLE_ADMIN, "/admin/home");
		}
	};
	
	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		if (request.getMethod().equals("GET")) {
			
			showLoginPage(request, response);
		}
		else {
			
			loginHandler(request, response);
		}
	}

	protected void showLoginPage (HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		forwardToJSP("login", request, response);
	}
	
	protected void validateRequest (String username, String password) throws InvalidDataException {

		if (StringUtils.isBlank(username)) {
			
			throw new InvalidDataException("Username is blank");
		} else if (StringUtils.isBlank(password)) {
			
			throw new InvalidDataException("Password is blank");
		}
	}
	
	protected void loginHandler (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer idRole  = Integer.parseInt(request.getParameter("role"));
		
		try {
			
			validateRequest(username, password);
			
			Account account = manager.getDataService().login(username, password, idRole);
			String homePage = homePages.get(idRole);
			if (homePage != null) {
				
				request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, account);
				redirectRequest(homePage, request, response);
			} else {
				
				throw new InvalidDataException("Unsupported role id " + idRole);
			}
		} catch (InvalidDataException e) {
			
			request.setAttribute(CommonConstants.VALIDATION_MESSAGE, e.getMessage());
			forwardToJSP("login", request, response);
		}
	}
}
