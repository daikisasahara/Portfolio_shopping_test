<%@page import="model.Product"%>
<%@page import="model.Dao_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<jsp:include page="/login_jsp/login_null_check.jsp"/>
	
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/top.css">
	<title>Amazones | マイページ画面</title>
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
		<div class="my-cart">
			<h2>マイカート</h2>
			
			<c:if test="${ ( shoppingCart.size() == 0 ) || ( shoppingCart == null ) }">
				<p>お客様の買い物かごには商品が入っていません。</p>
			</c:if>
			
			
			<!-- 合計金額 -->
			<c:set var="totalPrice" value="${ 0 }"/>
			
			<!-- 買い物かご番号 i -->
			<c:set var="i" value="${ 0 }"/>
			
				<!-- 買い物かごの中身を全件表示 -->
				
				<table border="1">
					<tr><th>商品名</th><th>商品価格</th><th>購入数</th><th>削除ボタン</th></tr>
					
					
					<c:forEach var="it" items="${ shoppingCart.iterator() }">
						
						<!-- 
							値引き価格 or 定価取得のための Product型 fix 取得
							タイムセール外の購入であれば定価に修正 
						-->
						<c:set var="fix" value="${ Dao_product.serch_prodId( it.getProduct().getProductId() ) }"/>
						
							<tr>
								<td><c:out value="${ it.getProduct().getName() }"/></td>
								<td><c:out value="${ fix.getPrice() }"/>円</td>
								<td><c:out value="${ it.getAmount() }"/></td>
								<td><a href="cansel_controller?cansel_num=${ i }"><button type="submit">削除</button></a></td>
							</tr>
						
						<!-- 買い物番号を 1 増やす -->
						<c:set var="i" value="${ i + 1 }"/>
						
						<!-- 合計金額を増やす -->
						<c:set var="totalPrice" value="${ totalPrice + ( fix.getPrice() * it.getAmount() ) }"/>
						
					</c:forEach>
					
				</table>
			
			
			<p>合計金額：<c:out value="${ totalPrice }"/>円</p>
			
			
			<c:if test="${ !( ( shoppingCart.size() == 0 ) || ( shoppingCart == null ) ) }">
				<p><a href="finish_controller"><input type="button" value="一括削除"></a></p>
				<p><a href="payment.jsp"><input type="button" value="お会計へ"></a></p>
			</c:if>
			
			<p><a href="history_controller"><input type="button" value="購入履歴確認"></a></p>
		</div>
		
		
		<jsp:include page="/design_jsp/design_page_footer.jsp"/>
		
		
	</div>
	
	
</body>
</html>