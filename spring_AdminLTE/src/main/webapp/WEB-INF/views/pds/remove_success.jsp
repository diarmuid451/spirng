<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("게시글삭제에 성공했습니다.");
	window.close();
	opener.parent.searchList_go(${pageMaker.cri.page}, "<%=request.getContextPath()%>/pds/list.do");
</script>

