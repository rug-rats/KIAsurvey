package com.sourceit.survey.service.mocks;

import com.sourceit.survey.model.Account;
import com.sourceit.survey.model.Role;
import com.sourceit.survey.utils.CommonConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class DataStorage implements CommonConstants {
	
	static final Role ADMIN_ROLE = new Role(ROLE_ADMIN, "Admin");
	static final Role TUTOR_ROLE = new Role(ROLE_TUTOR, "Tutor");
	static final Role STUDENT_ROLE = new Role(ROLE_STUDENT, "Student");

	static final List<Role> ALL_ROLES = new ArrayList<Role>() {{
		add(ADMIN_ROLE);
		add(TUTOR_ROLE);
		add(STUDENT_ROLE);
	}};

	static final List<Account> ALL_ACCOUNTS = new LinkedList<Account>() {{
		add(new Account("admin", "password", ALL_ROLES));
		add(new Account("tutor", "password", Arrays.asList(TUTOR_ROLE, STUDENT_ROLE)));
		add(new Account("student", "password", Arrays.asList(STUDENT_ROLE)));
	}};
}
