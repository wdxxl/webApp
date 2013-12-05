<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
<body>

<form:form method="post" modelAttribute="user" action="createUser">
    <form:label path="name">Name</form:label>
    <form:input path="name" /><br>
    <form:label path="password">Password</form:label>
    <form:password path="password" /><br>
    <form:label path="age">age</form:label>
    <form:input path="age" /><br>
    <form:label path="description">Description</form:label>
    <form:textarea placeholder="Please Enter" path="description" cols="20" rows="3"/><br>
    <form:hidden path="times"/>
    <br/>
    <input type="submit" value="Submit" />
    <input type="reset" value="Reset" />  
</form:form>

</body>
</html>
