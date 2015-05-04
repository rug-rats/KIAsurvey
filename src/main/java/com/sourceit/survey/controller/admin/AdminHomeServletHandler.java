package com.sourceit.survey.controller.admin;

import com.sourceit.survey.controller.common.CommonServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHomeServletHandler extends CommonServletHandler {
	private static final long serialVersionUID = 2821398058404801717L;

	@Override
	protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		forwardToJSP("admin/home", request, response);
	}
}
