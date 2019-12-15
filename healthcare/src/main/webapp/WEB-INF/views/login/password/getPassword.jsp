<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>헬스케어 비밀번호 찾기</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
	

<script>
$(document).ready(function() {

	
	
	$('#getPassword').click(function() {
		
		$("#text").remove();
		
		var id = $("#passForId").val();
		var email = $("#passForEmail").val();
		var emailValidation = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;		
		
		
		//이메일 유효성검사 
		if(!emailValidation.test(email)) {
			var html = "<h6 id='text'>올바른 이메일 형식이 아닙니다.<h6>";
			$("#fail").append(html);
			return;
		}
		
		if(id.length <= 3) {
			var html = "<h6 id='text'>아이디는 4글자 이상 입력하여 주십시오.<h6>";
			$("#fail").append(html);
			return;
		}
		
		
		
		
		if(id != "" && email != "") {
		$.ajax({
			url : "checkIdEmail.do",
			data : {
				id : id,
				email : email
			},
			type : "post",
			success : function(data) {
				var result = JSON.parse(data);

				if (result.status == "checksuccess") {
					location.href="passClearAndSendEmail.do?id="+id+"&email="+email;
					
					//location.href="nextGetPassword.do";
					
				} else if(result.status == "checkfail") {
					var html = "<h6 id='text'>등록된 아이디와 이메일을 조회할 수 없습니다.<h6>";
					$("#fail").append(html);
				}

			}
		})
		} 
		else {
			var html = "<h6 id='text'>아이디와 이메일을 확인해주세요.<h6>";
			$("#fail").append(html);
			return;
		} 
		
	})
	
	
})


//구현고민중
function sendEmail() {
	
}

</script>

<body>
<!-- 구현 후 처리 -->
<%--  <jsp:include page="/WEB-INF/views/Header.jsp"/> --%>

<h1>비밀번호 찾기</h1>

<h6>아이디를 입력하여 주십시오.</h6>
<input type="text" maxlength="10" id="passForId"/>
<br/>
<h6>가입시 작성한 이메일을 입력하여 주십시오.</h6>
<input type="text" maxlength="25" id="passForEmail"/>
<br/>
<button id="getPassword">비밀번호 찾기</button>
<br/>

<div id="fail"></div>
</body>
</html>