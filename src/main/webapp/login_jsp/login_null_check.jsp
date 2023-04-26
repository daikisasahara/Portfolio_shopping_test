<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	
	<%
		User user = ( User ) session.getAttribute( "user" ) ;
		
		
		// この if文を書くことで、ログイン成功ページのURLをコピペざれても、
		// ログインしていない状態でログイン済みにならない
		
		if( user == null ){
			request.getRequestDispatcher( "index.html" ).forward( request , response ) ;
		}
		
		// この if文はよく書くので、include で、別ファイルに書いておくことが一般的
	%>
	
		