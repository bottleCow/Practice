package com.ch.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.oracle.model.Dept;

@Mapper
public interface DeptDao {

	List<Dept> deptList();

	Dept select(int deptno);

	int insert(Dept dept);

	int update(Dept dept);

	int delete(int deptno);

}
