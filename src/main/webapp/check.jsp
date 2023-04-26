<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | 購入継続画面</title>
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
		<div class="check">
			<p>商品を買い物かごに追加しました。</p>
			<p>お会計は、マイカートよりお進みください。</p>
		</div>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
	</div>
	
	
</body>
</html>