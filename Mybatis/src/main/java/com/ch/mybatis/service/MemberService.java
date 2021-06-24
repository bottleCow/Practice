package com.ch.mybatis.service;

import com.ch.mybatis.model.Member;

public interface MemberService {

	Member select(String id);

	int insert(Member member);

}
