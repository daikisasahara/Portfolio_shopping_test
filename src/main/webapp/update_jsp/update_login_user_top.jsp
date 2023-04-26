<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/index.css">
	<title>Amazones | ログインに関する問い合わせ</title>
</head>
<body>
	
	<h1><a href="../index.html">Amazones</a></h1>
	
	<main>
		<h2>ログインに関する問い合わせ</h2>
		
		<form action="../faq_controller" method="post">
			<label>
				どのようなことでお困りですか？<br>
				<select name="faq_no">
					<option value="1">メールアドレスが変わったのですが、どうすればよろしいですか？</option>
					<option value="2">氏名が変わったのですが、どうすればよろしいですか？</option>
					<option value="3">住所が変わったのですが、どうすればよろしいですか？</option>
				</select>
			</label>
			
			<p><input type="submit"></p>
		</form>
	</main>
	
	
	
	
</body>
</html>