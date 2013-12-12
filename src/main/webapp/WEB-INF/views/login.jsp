<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
<body>

<form:form method="post" modelAttribute="appUser" action="login">
	<form:errors path="*" cssClass="errorblock" element="div" />
    <form:label path="loginName">loginName</form:label>
    <form:input path="loginName" />
    <form:errors path="loginName" cssClass="error" /><br>
    <form:label path="password">password</form:label>
    <form:password path="password" />
    <form:errors path="password" cssClass="error" /><br>
    <input type="submit" value="Submit" />
    <input type="reset" value="Reset" />  
</form:form>

</body>
</html>
