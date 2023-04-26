<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | TOP_ファッションページ</title>
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="/design_jsp/design_page_header.jsp"/>
	
	
	<main>
		
		<h2 class="category-top-page">商品選択</h2>
		
		<jsp:include page="/design_jsp/design_top_fashion_picture.jsp"/>
		
	</main>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
	</div>
	
	
</body>
</html>