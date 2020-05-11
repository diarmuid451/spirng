<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${id} 회원 수정에 성공했습니다.");
	location.href="detail.do?id=${id}";
	window.opener.location.href.reload(true);
</script>

