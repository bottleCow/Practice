package com.ch.ch08.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.ch08.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Emp> list(int deptno) {
		return sst.selectList("empns.list", deptno);
	}

	@Override
	public Emp select(int empno) {
		return sst.selectOne("empns.select", empno);
	}

	@Override
	public List<Emp> empList() {
		return sst.selectList("empns.empList");
	}
}
