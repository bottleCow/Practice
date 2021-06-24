package com.ch.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mybatis.dao.MemberDao;
import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;

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

	@Override
	public int update(Member member) {
		return md.update(member);
	}

	@Override
	public int delete(String id) {
		return md.delete(id);
	}

	@Override
	public void insertPhoto(List<MemberPhoto> photos) {
		for(MemberPhoto mp : photos) {
			md.insert(mp);
		}		
	}

	@Override
	public List<MemberPhoto> listPhoto(String id) {
		return md.listPhoto(id);
	}
	
}
