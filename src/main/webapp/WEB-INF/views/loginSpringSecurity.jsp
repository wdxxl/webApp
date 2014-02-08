<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Web App Spring Security - Login</title>
	<!-- Bootstrap Core CSS file -->
	<link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'></c:url>" rel="stylesheet" />
	<!-- Bootstrap Theme file (Optional) -->
	<link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-theme.min.css'></c:url>" rel="stylesheet" />
	<!-- jQuery file (make sure loaded before bootstrap.min.js ) -->
	<script type="text/javascript" src="<c:url value='/resources/jQuery/jquery-1.10.2.js'></c:url>"></script>
	<!-- Bootstrap Core JavaScript file -->
	<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'></c:url>"></script>
</head>
<body>
	<div class="container">
		<div class="row"><div class="col-md-12">&nbsp;</div></div>
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="section-page-title">Web App Spring Security - Login</span>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<c:url value='j_spring_security_check'></c:url>" method="post">
						<div class="form-group">
							<div class="col-lg-3 col-lg-offset-1">
							<label class="control-label">Username: </label>
							</div>
							<div class="col-lg-6">
							<input type="text" class="form-control" name="j_username" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-3 col-lg-offset-1">
							<label class="control-label">Password: </label>
							</div>
							<div class="col-lg-6">
							<input type="password" id="password" class="form-control" name="j_password"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-3 col-lg-offset-4">
								<button id="loginButton" class="btn btn-success">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			</div>
		</div>
	</div>
  </body>
</html>
