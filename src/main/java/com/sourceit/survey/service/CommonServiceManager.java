package com.sourceit.survey.service;

import com.sourceit.survey.service.interfaces.DataService;
import com.sourceit.survey.service.mocks.DataServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;


public final class CommonServiceManager {
	
	private static final Logger LOGGER = Logger.getLogger(CommonServiceManager.class);
	private static final String COMMON_SERVICES_MANAGER = "COMMON_SERVICES_MANAGER";
	
	private static final CommonServiceManager INSTANCE = new CommonServiceManager();
	
	private CommonServiceManager() {
		
		init();
	}
	
	public static CommonServiceManager getInstance (ServletContext context) {
		
		CommonServiceManager instance = (CommonServiceManager) context.getAttribute(COMMON_SERVICES_MANAGER);
		
		if(instance == null) {
			
			context.setAttribute(COMMON_SERVICES_MANAGER, INSTANCE);
			instance = INSTANCE;
		}
		return instance;
	}
	
	private DataService dataService;
	
	public DataService getDataService() {
		return dataService;
	}
	
	private void init() {
		
		dataService = new DataServiceImpl();
	}
	
	public void startAllServices(){
		
		LOGGER.info("All services have been started");
	}
	
	public void closeAllServices () {
		
		try {
			
			dataService.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		LOGGER.info("All services have been closed");
	}
}
