<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${pds.pno} 번 게시글 수정에 성공했습니다.");
	location.href="detail.do${pageMaker.makeQuery()}&pno=${pds.pno}&from=modify";
</script>

