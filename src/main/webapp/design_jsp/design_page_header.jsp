<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
	<header>
		
		<h1><a href="top.jsp">Amazones</a></h1>
		
		<div class="user-menu">
			<ul>
				<li>ようこそ、<c:out value="${ user.getName() }"/>さん</li>
				<li>
					<form action="search_controller" method="get" autocomplete="off">
						<label>
							<input type="text" name="key_word" placeholder="キーワード検索">
						</label>
						
						<label>
							<button type="submit">検索</button>
						</label>
					</form>
				</li>
				<li><a href="my_page.jsp"><img alt="買い物かごの写真" src="pic/pic_other/cart_icon.jpeg" width="32" height="32">マイカート</a></li>
				<li><a href="log_out_controller"><img alt="ログアウトの写真" src="pic/pic_other/logout_icon.jpeg" width="32" height="32">ログアウト</a></li>
			</ul>
		</div>
		
		<hr>
		
		<nav>
			<ul>
				<li><a href="top.jsp">TOP</a></li>
				<li><a href="top_food.jsp">食品</a></li>
				<li><a href="top_appliances.jsp">家電</a></li>
				<li><a href="top_fashion.jsp">ファッション</a></li>
				<li><a href="top_hobby.jsp">ホビー</a></li>
				<li><a href="top_book.jsp">書籍</a></li>
				<li><a href="top_movie.jsp">映像</a></li>
			</ul>
		</nav>
		
	</header>
	
	
	