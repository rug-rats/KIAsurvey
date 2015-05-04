<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="data-container">
	Hello, administrator ${CURRENT_SESSION_ACCOUNT.username }! <a href="<c:url value="/logout"/>">Logout</a>
</div>