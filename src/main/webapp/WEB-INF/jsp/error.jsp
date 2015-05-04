<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="data-container">
	Error<br/>
	
	Message : <c:out value="${errorMessage}"/><br/>
	<c:if test="${fullStackTrace} != null">
		Full stack trace : <c:out value="${fullStackTrace}"/><br/>
	</c:if>
</div>