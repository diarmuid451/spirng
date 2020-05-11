<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script type="text/javascript">
	alert("${param.id}님의 회원등록이 정상적으로 완료 되었습니다.");
	window.close();
	window.opener.location.reload(true);
</script>