package com.ch.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch08.model.Dept;
import com.ch.ch08.model.Emp;
import com.ch.ch08.service.DeptService;
import com.ch.ch08.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService es;
	
	// Emp테이블을 Dept테이블과 join했기 때문
	@Autowired
	private DeptService ds;
	
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		List<Emp> empList = es.list(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}
	
	@RequestMapping("empSelect")
	public String empSelect(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}
	
	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		//emp는 화면에서 입력한 데이터, emp2는 사번을 가지고 db에서 읽어온 데이터
		Emp emp2 = es.select(emp.getEmpno());
		if (emp2 == null) result = es.insert(emp);
		else result = -1; //이미 있는 데이터 
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}
	
	@RequestMapping("empInsertForm")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.list(); // 부서코드 선택
		List<Emp> empList = es.empList(); // 관리자 사번
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		model.addAttribute("deptno", deptno);
		return "/emp/empInsertForm";
	}

	@RequestMapping(value="empNoChk", produces="text/html;charset=utf-8")
	@ResponseBody
	public String empNoChk(int empno) {
		String data = "";
		Emp emp = es.select(empno);
		if (emp==null) data = "사용가능한 사번입니다";
		else data = "이미 사용중입니다";
		return data;
	}

	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);
		List<Dept> deptList = ds.list(); // 부서코드 선택
		List<Emp> empList = es.empList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		model.addAttribute("emp", emp);
		return "/emp/empUpdateForm";
	}

	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empUpdate";
	}
	
	@RequestMapping("empDelete")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empDelete";
	}

	@RequestMapping("allEmpList")
	public String allEmpList(Model model) {
		List<Emp> list = es.list();
		model.addAttribute("list", list);
		return "/emp/allEmpList";
	}
	
	
}
