package com.ch.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.oracle.model.Dept;
import com.ch.oracle.model.Emp;
import com.ch.oracle.service.DeptService;
import com.ch.oracle.service.EmpService;

@Controller
public class EmpController {
	//부모 테이블 
	@Autowired
	private EmpService es;
	
	//자식 테이블 추가
	@Autowired
	private DeptService ds;
	
	@RequestMapping("/emp/empList.do")
	public String empList(int deptno, Model model) {
		Dept dept= ds.select(deptno);
		List<Emp> empList = es.list(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}
	@RequestMapping("/emp/empInsertForm.do")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.deptList();  // 부서코드 선택
		List<Emp> empList = es.empList(); // 관리자 사번 선택
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		model.addAttribute("deptno", deptno);
		return "/emp/empInsertForm";
	}
	@RequestMapping(value = "/emp/empNoChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String empNoChk(int empno) {
		String data = "";
		Emp emp = es.select(empno);
		if (emp==null) data = "사용 가능한 사번입니다";
		else data = "사용중이니 다른 사번을 사용하시오";
		return data;
	}
	@RequestMapping("/emp/empInsert.do")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		// emp는 화면에서 입력한 데이터이고 emp2는 사번가지고 DB에서 읽어논 데이터
		Emp emp2 = es.select(emp.getEmpno());
		if (emp2 == null) result = es.insert(emp);
		else result = -1;  // 이미 있는 데이터 이므로 입력 금지
		model.addAttribute("result", result);
		model.addAttribute("emp", emp);
		return "/emp/empInsert";
	}
//	@RequestMapping("empUpdateForm")
//	public String empUpdateForm(int empno, Model model) {
//		Emp emp = es.select(empno);
//		List<Dept> deptList = ds.list();
//		List<Emp> empList = es.empList();
//		model.addAttribute("emp", emp);
//		model.addAttribute("deptList", deptList);
//		model.addAttribute("empList", empList);
//		return "/emp/empUpdateForm";
//	}
//	@RequestMapping("empUpdate")
//	public String empUpdate(Emp emp, Model model) {
//		int result = es.update(emp);
//		model.addAttribute("result", result);
//		model.addAttribute("emp", emp);
//		return "/emp/empUpdate";
//	}
//	@RequestMapping("empDelete")
//	public String empDelete(int empno, Model model) {
//		Emp emp = es.select(empno);
//		int result = es.delete(empno);
//		model.addAttribute("result", result);
//		model.addAttribute("emp", emp);
//		return "/emp/empDelete";
//	}
//	@RequestMapping("allEmpList")
//	public String allEmpList(Model model) {
//		List<Emp> list = es.list();
//		model.addAttribute("list", list);
//		return "/emp/allEmpList";		
//	}
	
	@RequestMapping("/emp/empSelect.do")
	public String empSelect(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}
}
