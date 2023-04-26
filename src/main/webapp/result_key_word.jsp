
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | キーワード検索結果ページ</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
	
		<div class="result-key-word">
			<c:choose>
				<c:when test="${ ( list.size() == 0 ) || ( list == null ) }">
					<p>検索結果：<c:out value="${ 0 }"/>件</p>
					<p>入力されたキーワードを含む商品はございません。</p>
				</c:when>
				<c:otherwise>
					
					<p>検索結果：<c:out value="${ list.size() }"/>件</p>
					
					<c:forEach var="k" items="${ list }">
						<p>商品名：<a href="product_controller?product=${ k.getProductId() }"><c:out value="${ k.getName() }"/></a></p>
					</c:forEach>
					
				</c:otherwise>
			</c:choose>
		</div>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
	</div>
	
	
</body>
</html>