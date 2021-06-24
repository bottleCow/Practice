package com.ch.mybatis.dao;

import com.ch.mybatis.model.Member;

public interface MemberDao {

	Member select(String id);

	int insert(Member member);

}
