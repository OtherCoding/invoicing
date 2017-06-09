package com.etc.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etc.biz.EmployeesBiz;
import com.etc.entity.Department;
import com.etc.entity.Employees;

@Controller
public class EmployeesAction {
	@Autowired
	private EmployeesBiz employeesBiz;
	//չʾԱ����Ϣ
	@RequestMapping("/showEmployees")
	public ModelAndView showEmployees(){
		System.out.println("����showEmployees������  ");
		List<Employees>employeesList = employeesBiz.queryEmployeesAll();
		System.out.println("��˾ȫ��Ա������->"+employeesList.size()+"��");
		ModelAndView mav = new ModelAndView("basic");
		mav.addObject("employeesList", employeesList);
		return mav;
	}
	@RequestMapping("/AddEmployees")
	public ModelAndView AddEmployees(HttpServletRequest req) throws UnsupportedEncodingException{
		System.out.println("AddEmployees������Ʋ�");
		int addEmpNo=Integer.valueOf(req.getParameter("addEmpNo"));
		String addEmpName=req.getParameter("addEmpName");
		int addSalary=Integer.valueOf(req.getParameter("addSalary"));
		String addJob=req.getParameter("addJob");
		int addDeptNo=Integer.valueOf(req.getParameter("addDeptNo"));
		Department department=new Department();
		department.setDeptNo(addDeptNo);
		Employees employees=new Employees(addEmpNo,addEmpName,addSalary,addJob,department);
		int num=employeesBiz.AddEmployees(employees);
		ModelAndView mav = new ModelAndView("basic");
		if(num!=0){
			mav.addObject("addEmployeesflag",1);
			System.out.println("���Ա���ɹ�");
		}else{
			mav.addObject("addEmployeesflag",0);
			System.out.println("���Ա��ʧ��");
		}
		return mav;
		
		}
		@RequestMapping("/deleteEmployees")
		public ModelAndView deleteEmployees(HttpServletRequest req){
			System.out.println("����deleteEmployees������  ");
			int deleteEmpNo=Integer.valueOf(req.getParameter("deleteEmpNo"));
			Employees employees=new Employees();
			employees.setEmpNo(deleteEmpNo);
			ModelAndView mav = new ModelAndView("basic");
			int num=employeesBiz.DeleteEmployees(employees);
			if(num!=0){
				mav.addObject("addEmployeesflag",1);
				System.out.println("ɾ��Ա���ɹ�");
			}else{
				mav.addObject("addEmployeesflag",0);
				System.out.println("ɾ��Ա��ʧ��");
			}
			return mav;
		}
		@RequestMapping("/editorEmployees")
		public ModelAndView editorEmployees(HttpServletRequest req) throws UnsupportedEncodingException{
			System.out.println("editorEmployees������Ʋ�");
			int editorSalary=Integer.valueOf(req.getParameter("editorSalary"));
			String editorJob=req.getParameter("editorJob");
			int editorEmpNo=Integer.valueOf(req.getParameter("editorEmpNo"));
			System.out.println(editorEmpNo);
			Employees employees=new Employees();
			employees.setEmpNo(editorEmpNo);
			employees.setJob(editorJob);
			employees.setSalary(editorSalary);
			int num=employeesBiz.editorEmployees(employees);
			ModelAndView mav = new ModelAndView("basic");
			if(num!=0){
				mav.addObject("editorEmployeesflag",1);
				System.out.println("�޸�Ա����Ϣ�ɹ�");
			}else{
				mav.addObject("editorEmployeesflag",0);
				System.out.println("�޸�Ա����Ϣʧ��");
			}
			
			
			return mav;
			
		}
		
	
	

}
