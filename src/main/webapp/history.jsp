<%@page import="model.Product"%>
<%@page import="model.History"%>
<%@page import="model.Dao_product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="/login_jsp/login_null_check.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | 購入履歴画面</title>
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
		<div class="history">
			<h2><c:out value="${ user.getName() }"/>さんの購入履歴</h2>
			
			<p><c:out value="${ historyMsg }"/></p>
			
			
				<table border="1">
					<tr><th>商品名</th><th>商品価格</th><th>購入数</th><th>購入日</th></tr>
					
					<c:forEach var="h" items="${ list }">
					
						<c:set var="id" value="${ h.getProductId() }"/>
						<c:set var="product" value="${ Dao_product.serch_prodId( id ) }"/>
						
						<tr>
							<td><c:out value="${ product.getName() }"/></td>
							<td><c:out value="${ product.getPrice() }"/>円</td>
							<td><c:out value="${ h.getOrder_num() }"/></td>
							<td><c:out value="${ h.getBoughtDay() }"/></td>
						</tr>
					</c:forEach>
				</table>
		</div>
		
		
		<jsp:include page="/design_jsp/design_page_footer.jsp"/>
		
		
	</div>
	
	
</body>
</html>