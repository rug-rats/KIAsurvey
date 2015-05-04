package com.sourceit.survey.controller.common;

import com.sourceit.survey.exceptions.InvalidDataException;
import com.sourceit.survey.model.Account;
import com.sourceit.survey.utils.CommonConstants;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LogoutHandler extends CommonServletHandler implements CommonConstants {
	private static final long serialVersionUID = 4544737546336836686L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {

		request.getSession().removeAttribute(CURRENT_SESSION_ACCOUNT);
		forwardToJSP("login", request, response);
	}

}
