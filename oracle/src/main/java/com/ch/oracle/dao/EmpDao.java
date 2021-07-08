package com.ch.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.oracle.model.Emp;

@Mapper
public interface EmpDao {

	List<Emp> list(int deptno);

	List<Emp> empList();

}
