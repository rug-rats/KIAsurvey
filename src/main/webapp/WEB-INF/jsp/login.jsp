<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="fullBg">

	<div class="container">
		<form class="form-signin" action="<c:url value="/login"/>" method="post">
			<h1 class="form-signin-heading">Please Login</h1>
			
			<jsp:include page="modules/validationMessage.jsp" />
			
			<input type="text" class="form-control" name="username" 
				   placeholder="Email Address" required="" autofocus="">
			<input type="password" class="form-control" name="password" 
				   placeholder="Password" required="">
			<p> 
				<label for="role">Select role </label>
				<select name="role" id="role">
					<option value="1">Administrator</option>
					<option value="2">Tutor</option>
					<option value="3">Student</option>
				</select>
			</p>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
		</form>
		<p class="text-center sign-up"><strong>Sign up</strong> for a new account</p>
	</div>
</div>

