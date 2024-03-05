<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/header.jsp" %>

<section class="mt-8">
	<div class="container mx-auto">
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td>${board.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${board.body }</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${board.updateDate }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${board.hit}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<button class="btn btn-outline btn-success" onclick="history.back()">뒤로가기</button>
			<c:if test="${sessionScope.member.getId() == board.getMemberId()}">
				<a href="/board/modify?id=${board.id }" class="btn btn-outline btn-success">글 수정</a>
			</c:if>
		</div>
	</div>
</section>
    
    
<%@ include file="../common/footer.jsp" %>