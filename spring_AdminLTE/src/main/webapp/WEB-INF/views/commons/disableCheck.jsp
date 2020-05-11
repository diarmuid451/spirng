<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script type="text/javascript">

alert("비활성화된 유저는 열람할 수 없습니다.\n메인 화면으로 넘어갑니다.");
if(window.opener) {
	window.close();
	window.opener.location.href = "<%=request.getContextPath()%>/member/list.do";
} else {
	location.href="<%=request.getContextPath()%>/member/list.do";
}
</script>