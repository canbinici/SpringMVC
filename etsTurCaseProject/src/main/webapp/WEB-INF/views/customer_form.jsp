<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Customer</title>
<%@ include file="./header.jsp"%>
</head>
<body>
    <div align="center">
        <h1>Add a New Customer</h1>
        <form:form action="save" method="post" modelAttribute="customer">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname" /></td>
            </tr>
			            <tr>
                <td>Blood:</td>
                <td><form:input path="blood" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="phone" /></td>
            </tr>
                        <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td  colspan= "2" align= "center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
<%@ include file="./footer.jsp"%>
</html>