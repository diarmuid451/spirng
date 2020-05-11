<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${board.writer}님의 게시글 등록이 정상적으로 완료 되었습니다.");
	window.close();
	window.opener.location.reload(true);
</script>

