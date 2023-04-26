<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="webapp/../css/index.css">
	<title>Amazones | お客様情報更新画面</title>
</head>
<body>
	
	<h1><a href="webapp/../index.html">Amazones</a></h1>
	
	<main>
		<h2>メールアドレス更新</h2>
		<p>メールアドレス更新を行います。</p>
		
		<p>お客様の以前使用していたメールアドレスと、新たに使用するメールアドレスを入力してください。</p>
		
		
		<form action="contoroller/../update_email_controller" method="post" autocomplete="off">
			<table>
				<tr>
					<td><label>以前使用していたメールアドレス( ID )：</label></td>
					
					<td>
						<label>
							<input type="email" name="old_email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
						</label>
					</td>
				</tr>
				
				<tr>
					<td><label>新たに使用するメールアドレス( ID )：</label></td>
					
					<td>
						<label>
							<input type="email" name="new_email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
						</label>
					</td>
				</tr>
			</table>
			
			<p><button type="submit">更新確定</button></p>
		</form>
	</main>
	
	
	
</body>
</html>