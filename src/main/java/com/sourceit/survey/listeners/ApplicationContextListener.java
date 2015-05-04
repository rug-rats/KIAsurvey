package com.sourceit.survey.listeners;

import com.sourceit.survey.service.CommonServiceManager;
import com.sourceit.survey.utils.CommonConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationContextListener implements ServletContextListener {
	
	private static final Logger LOGGER = Logger.getLogger(ApplicationContextListener.class);
	
	protected String getContext (ServletContextEvent sce) {
		
		String context = sce.getServletContext().getContextPath();
		return StringUtils.isBlank(context) ? "ROOT" : context;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		String context = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute(CommonConstants.CONTEXT, context);
		
		CommonServiceManager manager = CommonServiceManager.getInstance(sce.getServletContext());
		manager.startAllServices();
		
		LOGGER.info("Context '" + getContext(sce) + "' started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommonServiceManager manager = CommonServiceManager.getInstance(sce.getServletContext());
		manager.closeAllServices();
		
		LOGGER.info("Context '" + getContext(sce) + "' stopped");
	}
}
