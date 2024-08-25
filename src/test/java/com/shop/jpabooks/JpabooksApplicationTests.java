package com.shop.jpabooks;

import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpabooksApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MemberService memberService;

	@Test
	@DisplayName("멤버 조회 테스트")
	void findAll() {

		List<MemberDto> members = memberService.findAll();
		System.out.println("######");
	}


}
