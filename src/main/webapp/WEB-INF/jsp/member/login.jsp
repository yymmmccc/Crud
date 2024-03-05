<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../common/header.jsp" %>	

<section class="mt-10"> <!-- 마진-top 10 -->
	<div>
		<div>
			<form action="/member/doLogin" method="POST">
				<br>
				아이디 : <input name="loginId" type="text" placeholder="아이디를 입력해주세요."/>
				<br>
				비밀번호 : <input name="loginPw" type="text" placeholder="비밀번호를 입력해주세요."/>
				<br>
				<button>로그인</button>
			</form>
		</div>
	</div>
</section>



<%@ include file="../common/footer.jsp" %>