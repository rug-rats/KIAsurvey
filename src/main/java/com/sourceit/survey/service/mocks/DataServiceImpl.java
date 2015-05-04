package com.sourceit.survey.service.mocks;

import com.sourceit.survey.exceptions.CommonException;
import com.sourceit.survey.exceptions.InvalidDataException;
import com.sourceit.survey.model.Account;
import com.sourceit.survey.model.Role;
import com.sourceit.survey.service.interfaces.DataService;
import org.apache.commons.lang.StringUtils;

import java.util.List;


public class DataServiceImpl implements DataService {

	@Override
	public Account login(String username, String password, Integer role) throws InvalidDataException {
		
		for(Account a : DataStorage.ALL_ACCOUNTS) {
			
			if(StringUtils.equals(username, a.getUsername())) {
				
				if(StringUtils.equals(password, a.getPassword())) {
					
					for(Role currentRole : a.getRoles()) {
						
						if(currentRole.getId().equals(role)) {
							
							return a;
						}
					}
					
					throw new InvalidDataException("Invalid role");
				} else {
					
					throw new InvalidDataException("Invalid password");
				}
			}
		}
		throw new InvalidDataException("Account not found");
	}
	
	@Override
	public List<Role> listRoles() throws CommonException {
		return DataStorage.ALL_ROLES;
	}
	
	@Override
	public void close() {
		
	}
}
