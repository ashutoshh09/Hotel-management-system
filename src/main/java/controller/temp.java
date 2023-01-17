package controller;

import java.sql.Date;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f="2023-01-23";
		String g="2023-01-25";
		Long m=89878878798l;
		long h=Date.valueOf(f).getTime()-Date.valueOf(g).getTime();
		System.out.println(m.toString().length());
        long difference_In_Days
            = (h
               / (1000 * 60 * 60 * 24))
              % 365;
		System.out.println(difference_In_Days);
	}
	
}


//
//<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
//pageEncoding="ISO-8859-1"%>
//<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
//<!DOCTYPE html>
//<html>
//<head>
//<%@ page isELIgnored="false"%>
//<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
//<title>Hotel Management System</title>
//
//<!-- refrence our style sheet  -->
//<link rel="stylesheet"
//href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
//integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
//crossorigin="anonymous">
//</head>
//
//<body>
//
//
//<a href="home">Home</a>
//<hr />
//<s:form action="login" method="post" >
//	<tr>
//		<td>UserName</td>
//		<td><s:input path="username" /></td>
//	</tr>
//
//	<tr>
//
//		<td>Password</td>
//		<td><s:input path="password" /></td>
//	</tr>
//	<tr>
//		<td></td>
//		<td><input type="submit" value="login" /></td>
//	</tr>
//</s:form>
//
//
//</body>
//</html>