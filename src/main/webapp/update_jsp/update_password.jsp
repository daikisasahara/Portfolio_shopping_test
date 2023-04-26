<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/index.css">
	<title>Amazones | お客様情報更新画面</title>
</head>
<body>
	
	<h1><a href="../index.html">Amazones</a></h1>
	
	<main>
		<h2>パスワード更新</h2>
		<p>パスワード更新を行います。</p>
		
		<p>お客様のメールアドレスと、新たに設定するパスワードを入力してください。</p>
		
		<p>パスワードは、以下の条件に従って設定してください。</p>
			<ol>
				<li>英数字( 大文字・小文字 )、 ピリオド( . )、スラッシュ( / )、クエスチョン( ? )、ハイフン( - ) ) 使用可能</li>
				<li>文字数は、8文字以上24文字以下</li>
			</ol>
		
		<form action="contoroller/../update_password_controller" method="post" autocomplete="off">
			<table>
				<tr>
					<td><label>メールアドレス( ID )：</label></td>
					
					<td>
						<label>
							<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
						</label>
					</td>
				</tr>
				
				<tr>
					<td><label>パスワード：</label></td>
					
					<td>
						<label>
							<input type="password" name="pass" pattern="^[a-zA-Z0-9.?/-]{8,24}$" required>
						</label>
					</td>
				</tr>
			</table>
			
			<p><button type="submit">更新確定</button></p>
		</form>
	</main>
	
</body>
</html>