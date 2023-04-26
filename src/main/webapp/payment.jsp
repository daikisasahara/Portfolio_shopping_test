<%@page import="java.util.ArrayList"%>
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
	<title>Amazones | 支払いページ</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
	
	
	<div class="all-wrap">
	
	
	<jsp:include page="design_jsp/design_page_header.jsp"/>
	
	<h2 class="check">支払い方法選択</h2>
	
	<!-- 合計金額 -->
	<c:set var="totalPrice" value="${ 0 }"/>
	
	<!-- 買い物かご番号 i -->
	<c:set var="i" value="${ 0 }"/>
	
		<!-- 買い物かごの中身を全件表示 -->
		
		<table border="1">
			<tr><th>商品名</th><th>商品価格</th><th>購入数</th></tr>
			
			
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
					</tr>
					
				<!-- 買い物番号を 1 増やす -->
				<c:set var="i" value="${ i + 1 }"/>
				
				<!-- 合計金額を増やす -->
				<c:set var="totalPrice" value="${ totalPrice + ( fix.getPrice() * it.getAmount() ) }"/>
				
			</c:forEach>
		
		</table>
	
	<p class="total-price">合計金額：<c:out value="${ totalPrice }"/>円</p>
	
	<br>
		
		<div class="pay-method">
			<p>お支払方法を選択してください。</p>
			
			<form action="payment_controller" method="post">
				<table>
					<tr><td>
						<label><input type="radio" value="1" name="pay_method" checked>クレジットカード決済</label>
					</td></tr>
					
					<tr><td>
						<label><input type="radio" value="2" name="pay_method">銀行ネット決済（ネットバンキング)</label>
					</td></tr>
					
					<tr><td>
						<label><input type="radio" value="3" name="pay_method">キャリア決済</label>
					</td></tr>
					
					<tr><td>
						<label><input type="radio" value="4" name="pay_method">コンビニ決済</label>
					</td></tr>
					
					<tr><td>
						<label><input type="radio" value="5" name="pay_method">ペイジー（Pay-easy）</label>
					</td></tr>
					
					<tr><td>
						<label><input type="radio" value="6" name="pay_method">プリペイド決済</label>
					</td></tr>
				</table>
					
				<p><button type="submit">支払い確定</button></p>
			</form>
		</div>
	
	
	<jsp:include page="/design_jsp/design_page_footer.jsp"/>
	
	
	</div>
	
	
</body>
</html>