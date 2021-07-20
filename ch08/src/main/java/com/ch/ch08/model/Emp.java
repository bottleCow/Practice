package com.ch.ch08.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	// hibernate 또는 JPA에서 int 부분에 null이 있으면 에러, integer가 정상처리 됨
	private int empno;
	private String ename;
	private String job;
	private int mgr; // 관리자 manager
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	// 관리자 이름 보기
	private String mgrName;
	
	// Dept 테이블 join 하기
	private Dept dept;
}
