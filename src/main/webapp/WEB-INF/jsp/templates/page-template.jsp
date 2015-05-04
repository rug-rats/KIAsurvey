<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf8" />
	<meta name="description" content="My first demo jee application" />
	<meta name="keywords" content="jee, java, web, demo, com.sourceit.webtasks" />
	<meta name="author" content="mike" />
	<meta name="copyright" content="Copyright 2015, Webtasks demo application" />
	<title>Demo web application</title>
	
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/resources/css/common.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>
</head>
<body class="default-style">
	<header class="main-header group" id="main-header">
	<div class="header-left">
		<h1 class="logo header-chunk">
			Your logo here
		</h1>
	</div>
	</header>
	
	<section class="main">
		<jsp:include page="${currentPage}" flush="true" />
	</section>
	
	<footer class="site-footer">

		<div class="footer-left">
			©2015 <a href="/">Sourceit</a>
			<em>Demo of web task.</em>
		</div>
	</footer>
</body>
</html>