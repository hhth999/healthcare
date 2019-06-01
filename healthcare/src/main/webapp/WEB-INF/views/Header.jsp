<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.panel {
    background-color: #444;
    height: 48px;
    padding: 10px;
}
.panel a#login_pop, .panel a#join_pop {
    border: 2px solid #aaa;
    color: #fff;
    display: block;
    float: left;
    margin-left: 10px;
    padding: 5px 10px;
    text-decoration: none;
    text-shadow: 1px 1px #000;

    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    -ms-border-radius: 10px;
    -o-border-radius: 10px;
    border-radius: 10px;
	font-family:'dotum';
}
a#login_pop:hover, a#join_pop:hover {
    border-color: #eee;
}
.overlay {
    background-color: rgba(0, 0, 0, 0.6);
    bottom: 0;
    cursor: default;
    left: 0;
    opacity: 0;
    position: fixed;
    right: 0;
    top: 0;
    visibility: hidden;
    z-index: 1;

    -webkit-transition: opacity .5s;
    -moz-transition: opacity .5s;
    -ms-transition: opacity .5s;
    -o-transition: opacity .5s;
    transition: opacity .5s;
}
.overlay:target {
    visibility: visible;
    opacity: 1;
}
.popup {
    background-color: #fff;
    border: 3px solid #fff;
    display: inline-block;
    left: 50%;
    opacity: 0;
    padding: 15px;
    position: fixed;
    text-align: justify;
    top: 40%;
    visibility: hidden;
    z-index: 10;
	height:600px;
    -webkit-transform: translate(-50%, -50%);
    -moz-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    -o-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
	width:500px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    -ms-border-radius: 10px;
    -o-border-radius: 10px;
    border-radius: 10px;

    -webkit-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
    -moz-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
    -ms-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
    -o-box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
    box-shadow: 0 1px 1px 2px rgba(0, 0, 0, 0.4) inset;

    -webkit-transition: opacity .5s, top .5s;
    -moz-transition: opacity .5s, top .5s;
    -ms-transition: opacity .5s, top .5s;
    -o-transition: opacity .5s, top .5s;
    transition: opacity .5s, top .5s;
}
.overlay:target+.popup {
    top: 50%;
    opacity: 1;
    visibility: visible;
}
.close {
    background-color: rgba(0, 0, 0, 0.8);
    height: 30px;
    line-height: 30px;
    position: absolute;
    right: 0;
    text-align: center;
    text-decoration: none;
    top: -15px;
    width: 30px;

    -webkit-border-radius: 15px;
    -moz-border-radius: 15px;
    -ms-border-radius: 15px;
    -o-border-radius: 15px;
    border-radius: 15px;
}
.close:before {
    color: rgba(255, 255, 255, 0.9);
    content: "X";
    font-size: 24px;
    text-shadow: 0 -1px rgba(0, 0, 0, 0.9);
}
.close:hover {
    background-color: rgba(64, 128, 128, 0.8);
}
.popup p, .popup div {
    margin-bottom: 10px;
}
.popup label {
    display: inline-block;
    text-align: left;
    
}
.popup input[type="text"], .popup input[type="password"] {
    border: 1px solid;
    border-color: #999 #ccc #ccc;
    margin: 0;
    padding: 2px;
    margin-top: 10px;
    line-height:50px;
    margin-left:30px;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    -ms-border-radius: 2px;
    -o-border-radius: 2px;
    border-radius: 2px;
}
.popup input[type="text"]:hover, .popup input[type="password"]:hover {
    border-color: #555 #888 #888;
}

#label1 {
	text-align:center;
	padding-bottom: 20px;
}

#idf, #passwordf {
	 font-weight: bold;
	 margin-left: 30px;
}

#passwordf {
	margin-top: 20px;
}

#Login {
	margin-top:50px;
    margin-left: 80%;
    }


</style>
<title>Insert title here</title>
</head>
<body>
<span style="font-size: 20px; font-family: 굴림;"> 헬스케어 메인화면입니다. </span>
	<span>출석한 날짜 : 일 </span>
	<span> 님의 권장 칼로리</span>
	<span><a href="#login_form">로그인 / 로그아웃</a>
		<a href="signUpPage.do">마이페이지/관리자/회원가입</a></span>

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


    <a href="#x" class="overlay" id="login_form"></a>
        <div class="popup">
            <h2 id="label1">헬스케어 로그인</h2>
            <div>
                <label for="id" id="idf">아이디</label>
                <br/>
                <input type="text" id="id" value="" size="55" placeholder="아이디를 입력하여 주십시오" />
            </div>
            <div>
                <label for="password" id="passwordf">비밀번호</label>
                <br/>
                <input type="password" id="password" value="" size="55" placeholder="비밀번호를 입력하여 주십시오" />
            </div>
            <div style="margin-top:30px;">
            <img src="/healthcare/resources/images/KaKao.jpg" height="30px" width="30px">
            <img src="/healthcare/resources/images/Naver.jpg" height="30px" width="30px">
            
            </div>
            <input type="button" id="Login" value="로그인" />
			
			<div>
			<p>아직 헬스케어 회원이 아니신가요? <a href="#">헬스케어 회원가입 하러가기</a></p>
			<p>이메일 / 비밀번호를 까먹으셨나요? <a href="#">이메일 / 비밀번호 찾기</a></p>
			</div>
            <a class="close" href="#close"></a>
        </div>

       
</body>
</html>