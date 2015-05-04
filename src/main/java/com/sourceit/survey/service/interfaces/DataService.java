package com.sourceit.survey.service.interfaces;

import com.sourceit.survey.exceptions.CommonException;
import com.sourceit.survey.exceptions.InvalidDataException;
import com.sourceit.survey.model.Account;
import com.sourceit.survey.model.Role;


import java.util.List;


public interface DataService extends AutoCloseable {
	
	Account login(String username, String password, Integer role) throws InvalidDataException;
	List<Role> listRoles() throws CommonException;
}
