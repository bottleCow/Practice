package com.ch.mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mybatis.model.Member;
import com.ch.mybatis.model.MemberPhoto;

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

	@Override
	public int update(Member member) {
		return sst.update("memberns.update", member);
	}

	@Override
	//실제 삭제하지 않고 del값을 n에서 y로만 바꿔줌
	public int delete(String id) {
		return sst.update("memberns.delete", id);
	}

	@Override
	public void insert(MemberPhoto mp) {
		sst.insert("memberns.insertPhoto", mp);
	}

	@Override
	public List<MemberPhoto> listPhoto(String id) {
		return sst.selectList("memberns.listPhoto", id);
	}//여러건 검색=selectList member.xml에서 쿼리찾아서 실행
	
}
