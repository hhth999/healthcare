<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Healthcare Main</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$(document).mouseup(function (e){

			var container = $("#modalLogin");

			if(container.has(e.target).length === 0)

			container.hide();

			});
	});

</script>
<style type="text/css">
.modalLogin {
	display: none;
	position: fixed;
	left: 0;
	top: 0;
	_position: absolute;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.modalLogin .modalWindow {
	display: block;
	position: fixed;
	border: 0;
	left: 0;
	top: 0;
	_position: absolute;
	width: 100%;
	height: 100%;
	background: #000;
	-moz-opacity: .50;
	filter: alpha(opacity = 50);
	opacity: .50;
}

.modalLogin .loginLayer {
	position: absolute;
	width: 440px;
	top: 150px;
	left: 50%;
	margin: 0 0 0 -230px;
	border: 10px solid #D6D6D6;
	background: #F2F2F2;
}

.modalLogin .loginLayer .modal_header {
	height: 130px;
	background: #151515 url(/healthcare/resources/images/modal_label.gif)
		no-repeat 20px 20px;
}

.modalLogin .loginLayer .modal_header .text_welcome {
	position: absolute;
	top: 55px;
	left: 20px;
	color: #FFF;
}

.modalLogin .loginLayer .modal_header .help {
	position: absolute;
	top: 85px;
	left: 20px;
	list-style: none;
	text-align: center;
}

.modalLogin .loginLayer .modal_header .help li {
	float: left;
	display: inline;
	font-size: 12px;
	padding-right: 10px;
}

.modalLogin .loginLayer form {
	display: block;
	*zoom: 1;
}

.modalLogin .loginLayer form:after {
	content: "";
	display: block;
	clear: both;
}

.modalLogin .loginLayer .input_box {
	list-style: none;
	background: url(/healthcare/resources/images/modal_username.gif)
		no-repeat 0 0;
	padding: 0 0 0 75px;
	margin: 20px 0 0 20px;
}

.modalLogin .loginLayer .inputText {
	width: 300px;
	height: 25px;
	padding: 0 0 0 10px;
	margin: 0 0 10px 0;
	border: 1px solid #ddd;
	font: 16px Tahoma;
	color: #333;
	font-weight: bold;
}

.modalLogin .loginLayer .inputText:focus {
	background-color: #fbfbfb;
}

.modalLogin .loginLayer .inputCheck {
	margin: 0 3px 0 0;
	width: 13px;
	height: 13px;
	vertical-align: middle;
}

.modalLogin .loginLayer .keep {
	margin: 0 0 10px 96px;
	font-size: 12px;
	line-height: normal;
	white-space: nowrap;
}

.modalLogin .loginLayer .keep label {
	color: #444;
	letter-spacing: -1px;
}

.modalLogin .loginLayer .loginBtn {
	text-align: center;
	background: #E8E8E8;
	padding: 10px 0;
}

.modalLogin .loginLayer .loginBtn span {
	margin: 0 20px;
}

.modalLogin .loginLayer .close {
	position: absolute;
	cursor: pointer;
	border: 0;
	padding: 0;
	top: 0;
	right: 0;
	width: 50px;
	height: 50px;
	background: url(/healthcare/resources/images/buttonCloseX.gif) no-repeat
		center center;
}

.modalLogin .loginLayer .close span {
	position: absolute;
	font-size: 0;
	line-height: 0;
	width: 0;
	height: .;
	overflow: hidden;
	visibility: hidden;
}
</style>
</head>
<body>
	<span style="font-size: 20px; font-family: 굴림;"> 헬스케어 메인화면입니다. </span>
	<span>출석한 날짜 : 일 </span>
	<span> 님의 권장 칼로리</span>
	<span><a href="#modalLogin"
		onclick="jQuery('#modalLogin').css('display','block');">로그인 / 로그아웃</a>
		<a href="#">마이페이지/관리자/회원가입</a></span>

	<p>마이페이지</p>
	<a href="#">회원정보보기</a>
	<a href="#">내가쓴글보기</a>

	<p>일정관리</p>
	<a href="#">운동일정관리</a>
	<a href="#">식단관리하기</a>

	<p>커뮤니티</p>
	<a href="fboardlist.do">자유게시판</a>
	<a href="#">질문게시판</a>
	<a href="#">회원 컨테스트</a>
</body>

<!--// 모달 로그인 시작  -->
<!--%import("filter/login.xml")-->
<div id="modalLogin" class="modalLogin">
	<span class="modalWindow"></span>
	<div id="loginLayer" class="loginLayer">
		<div class="modal_header">
			<p class="text_welcome">Welcome to Healthcare Website!</p>
			<ul class="help">
				<li><a href="{getUrl('act','dispMemberSignUpForm')}"
					class="button black"><span>회원가입</span></a></li>
				<li><a href="{getUrl('act','dispMemberFindAccount')}"
					class="button black"><span>계정찾기</span></a></li>
				<li><a href="{getUrl('act','dispMemberResendAuthMail')}"
					class="button black"><span>인증메일발송</span></a></li>
			</ul>
		</div>
		<button type="button" class="close"
			onclick="document.getElementById('modalLogin').style.display='none'"
			accesskey="X">
			<span>Close</span>
		</button>
		<form action="" method="post"
			onsubmit="return procFilter(this, login)">
			<ul class="input_box">
				<li><input name="user_id" type="text" class="inputText"
					id="uid" /></li>
				<li><input name="password" type="password" class="inputText"
					id="upw" /></li>
			</ul>
			<p class="keep">
				<input name="keep_signed" type="checkbox" id="keepA" value="Y"
					class="inputCheck"
					onclick="if(this.checked) return confirm('{$lang->about_keep_signed}');" /><label
					for="keepA">로그인 유지</label>
			</p>
			<div class="loginBtn">
				<p>
					<span class="button blue large"><input type="submit"
						value="{$lang->cmd_login}" /></span><span class="button large"><input
						type="button" value="{$lang->cmd_back}"
						onclick="document.getElementById('modalLogin').style.display='none'"
						accesskey="X"></span>
				</p>
			</div>
		</form>
	</div>
</div>
<!--//  modalLogin end -->
</html>