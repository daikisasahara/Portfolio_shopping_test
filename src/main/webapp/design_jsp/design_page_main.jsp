<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@page import="java.time.ZonedDateTime"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<main>
		
		<c:set var="now" value="${ ZonedDateTime.now() }"/>
		<c:set var="hour" value="${ now.getHour() }"/>
		
		<div class="main-visual">
			<c:choose>
				<c:when test="${ 18 <= hour }">
					<p>
						<a href="top_food.jsp">
							<img alt="セールの写真" src="pic/pic_other/sale.jpg" width="700" height="350">
						</a>
					</p>
				</c:when>
				
				<c:when test="${ ( 10 <= hour ) && ( hour <= 14 ) }">
					<p>
						<a href="top_movie.jsp">
							<img alt="セールの写真" src="pic/pic_other/sale.jpg" width="700" height="350">
						</a>
					</p>
				</c:when>
				
				<c:otherwise>
					<p>
						<img alt="メインビジュアルの写真" src="pic/pic_other/mv.jpg" width="700" height="350">
					</p>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="picture">
			<ul>
				<li>
					<a href="top_food.jsp">
						<img alt="食卓の写真" src="pic/pic_other/top_food_page.jpg" width="700" height="500">
					</a>
				</li>
				<li>
					<a href="top_appliances.jsp">
						<img alt="家電の写真" src="pic/pic_other/top_appliances_page.jpg" width="700" height="500">
					</a>
				</li>
			</ul>
		</div>
		
		<div class="picture">
			<ul>
				<li>
					<a href="top_fashion.jsp">
						<img alt="洋服の写真" src="pic/pic_other/top_fashion_page.jpg" width="700" height="500">
					</a>
				</li>
				<li>
					<a href="top_hobby.jsp">
						<img alt="子供が遊ぶ写真" src="pic/pic_other/top_hobby_page.jpg" width="700" height="500">
					</a>
				</li>
			</ul>
		</div>
		
		<div class="picture">
			<ul>
				<li>
					<a href="top_book.jsp">
						<img alt="本棚の写真" src="pic/pic_other/top_book_page.jpg" width="700" height="500">
					</a>
				</li>
				<li>
					<a href="top_movie.jsp">
						<img alt="MOVIEの写真" src="pic/pic_other/top_movie_page.jpg" width="700" height="500">
					</a>
				</li>
			</ul>
		</div>
		
		
		
		<br><br><br><br><br><br><br><br><br>
		
		
		
	</main>
	
	
	
	
	
		