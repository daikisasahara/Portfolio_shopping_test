<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/index.css">
	<title>お買い物サイト | ログインエラー画面</title>
</head>
<body>
	
	<h1><a href="index.html">Amazones</a></h1>
	
	<div class="login-error">
	
		<p>ログインに失敗しました。</p>
		
		<p><c:out value="${ msg }"/></p>
		
		<p>ログインページに<a href="index.html">戻る</a></p>
	
	</div>
	
</body>
</html>