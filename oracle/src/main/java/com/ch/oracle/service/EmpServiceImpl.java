package com.ch.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.oracle.dao.EmpDao;
import com.ch.oracle.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;

	@Override
	public List<Emp> list(int deptno) {
		return ed.list(deptno);
	}

	@Override
	public List<Emp> empList() {
		return ed.empList();
	}
	
}
