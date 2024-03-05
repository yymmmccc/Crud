package com.example.crud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.crud.vo.Member;

@Mapper
public interface MemberMapper {
	
	public void doJoin(String loginId, String loginPw, String name, String nickname,
			String phoneNum, String email, String address);

	public Member getMemberByLoginId(String loginId);

	public void doModify(@Param("id") int id, @Param("nickname") String nickname, @Param("phoneNum") String phoneNum, @Param("email")String email, @Param("address") String address);

}
