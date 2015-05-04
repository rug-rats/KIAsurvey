<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${VALIDATION_MESSAGE} != null">
	<p><c:out value="${VALIDATION_MESSAGE}"/></p>
</c:if>