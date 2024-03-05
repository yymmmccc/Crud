<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/header.jsp" %>

<section class="mt-10"> <!-- 마진-top 10 -->
	<div>
		<div>
			<form action="/member/doModify" method="GET">
				<input type="hidden" name="id" value="${sessionScope.member.getId() }"/>
				<br>
				아이디 : <input type="text" value="${sessionScope.member.getLoginId() }" readonly/>
				<br>
				이름 : <input type="text" value="${sessionScope.member.getName()}" readonly/>
				<br>
				닉네임 : <input name="nickname" type="text" value="${sessionScope.member.getNickname()}"/>
				<br>
				전화번호 : <input name="phoneNum" type="text" value="${sessionScope.member.getPhoneNum()}"/>
				<br>
				이메일 : <input name="email" type="text" value="${sessionScope.member.getEmail()}" />
				<br>
				주소 : <input name="address" type="text" value="${sessionScope.member.getAddress()}"/>
				<br>
				나의 등급 : ${sessionScope.member.getGrade()}
				<br>
				<button>회원정보수정</button>
				<a class="btn btn-outline btn-success">비밀번호 변경</a>
			</form>
		</div>
	</div>
</section>

<%@ include file="../common/footer.jsp" %>