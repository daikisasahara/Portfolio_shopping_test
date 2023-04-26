<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | 決済完了画面</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<header><h1><a href="finish_controller">Amazones</a></h1></header>
	
	<div class="pay-finish">
		<h2>決済完了</h2>
		
		<p><c:out value="${ pay_method_msg }"/></p>
		
		<p><a href="log_out_controller">ログアウト</a></p>
		
		<p><a href="finish_controller">TOPページ</a></p>
	</div>
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
	</div>
	
	
</body>
</html>