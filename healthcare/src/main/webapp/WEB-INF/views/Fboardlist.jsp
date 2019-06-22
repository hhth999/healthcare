<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>헬스케어 자유게시판</title>
</head>
<body>
<h1 style="text-align:center;">헬스케어 자유게시판</h1>
 <c:forEach items="${list}" var="fdto">
  <tr>
  	<td class="w3-center">${fdto.free_seq}</td>
  	
  	
  	
  	</tr>
  	</c:forEach>

</body>
</html>