<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | お客様情報更新結果ページ</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
	
	<h1>Amazones</h1>
	
	<h2>お客様情報更新</h2>
	
	<p><c:out value="${ msg }"/></p>
	
	<p><a href="index.html">ログインページへ</a></p>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
</body>
</html>