<%@page import="model.Picture"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.time.ZonedDateTime"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<% Product pro = ( Product ) request.getAttribute( "pro" ) ; %>
	
	<jsp:include page="/login_jsp/login_null_check.jsp"/>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | 商品詳細ページ</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
	
	
	<div class="all-wrap">
		
		<%= pro.getProductId() %>
		<jsp:include page="design_jsp/design_page_header.jsp"/>
		
		<div class="product-page">
		
			<h2>商品詳細</h2>
			
			<p><jsp:include page="design_jsp/design_product_picture.jsp"/></p>
			
			
			<p>商品名：<%= pro.getName() %></p>
			<br>
			<p>価格：<c:out value="${ pro.getPrice() }"/>円</p>
			<br>
			<p>容量・サイズ：<%= pro.getVolume_size() %></p>
			<br>
			<p>説明文：<br><%= pro.getText().replace( "\n" , "<br>" ) %></p>
			
			<br>
			
			<form action="top_controller" method="get">
				
				<jsp:include page="design_jsp/design_product_num.jsp"/>
				
				
				<label>
					<!-- 
						取得した商品IDを controller に投げる。
						ユーザーに見せる必要はないので、input type="hidden" を使用。
					-->
					<input type="hidden" name="product" value="<%= pro.getProductId() %>">
				</label>
				
				<p>
					<label>
						<button type="submit" name="submit" value="商品を買い物かごに追加">商品を買い物かごに追加</button>
						<button type="submit" name="submit" value="すぐに購入へ">すぐに購入へ</button>
					</label>
				</p>
				
			</form>
			
		</div>
		
		
		<jsp:include page="/design_jsp/design_page_footer.jsp"/>
		
		
	</div>
	
	
</body>
</html>