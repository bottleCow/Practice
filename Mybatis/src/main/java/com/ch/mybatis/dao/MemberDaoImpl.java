package com.ch.mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatis.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired //데이터 연결
	private SqlSessionTemplate sst;

	@Override
	public Member select(String id) {
		return sst.selectOne("memberns.select", id);
		//한건 검색=selectOne member.xml에서 쿼리찾아서 실행
	}

	@Override
	public int insert(Member member) {
		return sst.insert("memberns.insert", member);
	}
	
}
