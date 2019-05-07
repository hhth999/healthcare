<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html; charset=utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계정생성</title>
<script type="text/javascript">
</script>
</head>
<body>
	<form action="signUp.do" method="post">
		<fieldset>
			<legend align="center">회원가입</legend>
			<ol>
				<li>
					<label for="id">아이디</label> <input type="text" id="id" name="id">
				</li>
				<li>
					<label for="password">비밀번호</label> <input type="password" id="password" name="password"><br>
					<label for="password2">비밀번호확인</label> <input type="password" id="password2" name="password2">
				</li>
				<li>
					<label for="name">이름</label> <input type="text" id="name" name="name">
				</li>
				<li>
					<label for="phone">휴대폰</label> <input type="text" id="phone" name="phone">
				</li>
			</ol>
			<ol>
				<li>
					<label for="birth">생년월일</label> <input type="text" id="birth" name="birth">
				</li>
				<li>
					<input type="radio" name="gender" value="male">남
					<input type="radio" name="gender" value="female">여
				</li>
				<li>
					<label for="address">주소</label> <input type="text" id="address" name="address">
				</li>
				<li>
					<label for="email">이메일</label> <input type="text" id="email" name="email">
				</li>
				<li>
					<label for="height">키</label> <input type="text" id="height" name="height">
				</li>
				<li>
					<label for="weight">몸무게</label> <input type="text" id="weight" name="weight">
				</li>
			</ol>
			<ol>
				
			</ol>
		
				<p align="center">
					<input type="reset" value="초기화"> <input type="submit"	value="완료" id="submit">
				</p>
		</fieldset>
	</form>
</body>
</html>