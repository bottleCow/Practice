package com.ch.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mybatis.dao.MemberDao;
import com.ch.mybatis.model.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired //.Dao와 연결
	private MemberDao md;

	@Override
	public Member select(String id) {
		return md.select(id);
	}

	@Override
	public int insert(Member member) {
		return md.insert(member);
	}
	
}
