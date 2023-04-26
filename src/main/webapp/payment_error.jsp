<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | 決済エラーページ</title>
</head>
<body>
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
	<h2>決済エラー</h2>
	
	
	<p>決済エラーが発生しました。</p>
	<p>もう一度やり直してください。</p>
	
	
	<p><a href="log_out_controller">ログアウト</a></p>
	
	
	<p><a href="top.jsp">TOPページ</a></p>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
</body>
</html>