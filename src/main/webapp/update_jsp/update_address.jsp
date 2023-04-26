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
		<h2>お客様住所更新</h2>
		<p>お客様住所更新を行います。</p>
		
		<p>お客様のメールアドレスと、変更後の住所を入力してください。</p>
		
		
		<form action="contoroller/../update_address_controller" method="post" autocomplete="off">
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
					<td><label>変更後の住所：</label></td>
					
					<td>
						<label>
							<input type="text" name="address" pattern="^[0-9ぁ-んァ-ヶｱ-ﾝﾞﾟ一-龠]*$" required>
						</label>
					</td>
				</tr>
			</table>
			
			<p><button type="submit">更新確定</button></p>
		</form>
	</main>
	
</body>
</html>