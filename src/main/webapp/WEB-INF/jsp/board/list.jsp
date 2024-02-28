<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/header.jsp" %>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boards }">  
		<tr>
			<td>${board.id}</td>
			<td><a href="/board/detail?id=${board.id }">${board.title }</a></td>
			<td>${board.nickname }</td>
			<td>${board.regDate.substring(11, 16)}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<c:if test="${!empty member }">
	<a href="/board/write?type=${param.type }">글 작성</a>
</c:if>


<%@ include file="../common/footer.jsp" %>