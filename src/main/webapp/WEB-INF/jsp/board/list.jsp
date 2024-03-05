<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/header.jsp" %>
<form action="list" method="GET">
	<select name="searchType" value="${searchType}">
		<option value="title" ${searchType == 'title' ? 'selected' : ''}>제목</option>
		<option value="body"  ${searchType == 'body' ? 'selected' : ''}>내용</option>
		<option value="titleAndBody" ${searchType == 'titleAndBody' ? 'selected' : ''}>제목 + 내용</option>
	</select>
	<input type="text" name="searchKeyword" value="${searchKeyword }" palceholder="검색어를 입력하세요."/>
	<button>검색</button>
</form>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boards }">  
		<tr>
			<td>${board.id}</td>
			<td><a href="/board/detail?id=${board.id }">${board.title }</a></td>
			<td>${board.nickname }</td>
			<td>${board.regDate.substring(11, 16)}</td>
			<td>${board.hit }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${paging.startPage > 1 }">
	<a href="/board/list?type=${type }&page=${paging.startPage - 1}&searchType=${searchType}&searchKeyword=${searchKeyword}">이전</a>  <!-- 1페이지에서 다음으로가면 21페이지의 데이터보여줌 -->
</c:if>

<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="pageCnt">
	<c:choose>
		<c:when test="${pageCnt == param.page}">
			<a href="/board/list?type=${type }&page=${pageCnt }&searchType=${searchType}&searchKeyword=${searchKeyword}" style="color : red">${pageCnt }</a>
		</c:when>
		<c:otherwise>
			<a href="/board/list?type=${type }&page=${pageCnt }&searchType=${searchType}&searchKeyword=${searchKeyword}">${pageCnt }</a>
		</c:otherwise>
	</c:choose>
</c:forEach>

<c:if test="${paging.totalPage != paging.endPage }">
	<a href="/board/list?type=${type }&page=${paging.endPage + 1}&searchType=${searchType}&searchKeyword=${searchKeyword}">다음</a>  <!-- 1페이지에서 다음으로가면 21페이지의 데이터보여줌 -->
</c:if>

	
<c:if test="${!empty member }">
	<a href="/board/write?type=${type }">글 작성</a>
</c:if>


<%@ include file="../common/footer.jsp" %>