package com.ch.oracle.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.oracle.model.Dept;
import com.ch.oracle.service.DeptService;
@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	@RequestMapping("/dept/deptList.do")
	public String deptList(Model model) {
		List<Dept> deptList = ds.deptList();
		model.addAttribute("deptList", deptList);
		return "/dept/deptList";
	}
	@RequestMapping("/dept/deptInsertForm.do")
	public String deptInsertForm() {
		return "/dept/deptInsertForm";
	}
	
	@RequestMapping("dept/deptInsert.do")
	public String deptInsert(Dept dept, Model model) {
		int result = 0;
		Dept dept2 = ds.select(dept.getDeptno());
		if (dept2 == null) result = ds.insert(dept);
		else result = -1; // 중복된 데이터 입력
		model.addAttribute("result", result);
		return "/dept/deptInsert";
	}
	
	@RequestMapping("/dept/deptUpdateForm.do")
	public String updateDeptForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "/dept/deptUpdateForm";
	}
	
	@RequestMapping("/dept/deptUpdate.do")
	public String deptUpdate(Dept dept, Model model) {
		int result = ds.update(dept);
		model.addAttribute("result", result);
		return "/dept/deptUpdate";
	}
	
	@RequestMapping("/dept/deptDelete.do")
	public String deleteDept(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "/dept/deptDelete";
	}
	
	@RequestMapping(value = "/dept/deptNoChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String deptNoChk(int deptno) {
		String data = "";
		Dept dept = ds.select(deptno);
		if (dept == null) data = "사용가능한 부서코드 입니다";
		else data ="사용중이니 다른 부서코드를 사용하시오";		
		return data;
	}
}