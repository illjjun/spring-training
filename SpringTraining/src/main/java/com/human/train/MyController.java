package com.human.train;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/ad_room")
	public String room(HttpServletRequest hsr,Model m) {
		iEmp jc=sqlSession.getMapper(iEmp.class);
		ArrayList<Room> Room=jc.getRoom();
		System.out.println("size ["+Room.size()+"]");
		m.addAttribute("Room",Room);
		
		return "addRoom";
		}
	@RequestMapping("/art")public String ART() {return "addRoomtype";}
	@RequestMapping("/menuadd")public String doMenuadd() {return "addMenu";}
	
	@RequestMapping("/room_add")
	public String room_add(HttpServletRequest hsr,Model m) {
		
		return "addRoom";	
	}
	
	@RequestMapping("/addRoomtype")
	public String addRoomtype(HttpServletRequest hsr) {
		String name=hsr.getParameter("typename");
		int typecode=Integer.parseInt(hsr.getParameter("typecode"));
		iEmp emp=sqlSession.getMapper(iEmp.class);
		emp.addType(typecode, name);
		return "addRoomtype";		
	}
	
	@RequestMapping("/addRoom")
	public String addRoom(HttpServletRequest hsr) {
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		emp.addRoom(name, type, howmany, howmuch);
		
		return "redirect:/ad_room";
	}
	
	
	
	@RequestMapping("/addmenu")
	public String doAddMenu(HttpServletRequest hsr) {
		String mname=hsr.getParameter("menu_name");
		int price=Integer.parseInt(hsr.getParameter("price"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		emp.addMenu(mname, price);
		return "addMenu";
	}
	
	@RequestMapping("/jc")
	public String joincon(Model m) {
		iEmp jc=sqlSession.getMapper(iEmp.class);
		ArrayList<joincon> aljc=jc.getjoinCon();
		System.out.println("size ["+aljc.size()+"]");
		m.addAttribute("aljc",aljc);
		return "joincon";
	}
	
	@RequestMapping("/cnt")
	public String docountryList(Model m) {
		iEmp cnt=sqlSession.getMapper(iEmp.class);
		ArrayList<countries> alcnt=cnt.getCountries();
		System.out.println("size ["+alcnt.size()+"]");
		m.addAttribute("alcnt",alcnt);
		return "country";
	}
	
	@RequestMapping("/emp")
	public String doEmpList(Model m) {
		iEmp emp=sqlSession.getMapper(iEmp.class);
		ArrayList<Employee> alEmp=emp.getEmpList();
		System.out.println("size ["+alEmp.size()+"]");
		m.addAttribute("alEmp",alEmp);
		return "emp";
	}
	
	@RequestMapping(value="/look",method=RequestMethod.GET)
	public String look(Model model,HttpServletRequest hsr) {
		
		model.addAttribute("mobile","010-3576-3637");
		return "look";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest hsr) {
		String nick=hsr.getParameter("nickname");
		System.out.print("nick ["+nick+"]");
		return "redirect:/look";
	}
	@RequestMapping("/input")
	public String input(HttpServletRequest hsr,Model model) {
		
		return "input";
	}
	@RequestMapping("/calc")
	public String calc(HttpServletRequest hsr,Model model) {
//		String x1=hsr.getParameter("x1");
//		String x2=hsr.getParameter("x2");
//		String error="";
//		boolean isNumeric =  x1.matches("[+-]?\\d*(\\.\\d+)?");
//		boolean isNumeric2 =  x2.matches("[+-]?\\d*(\\.\\d+)?");
//		if(x1.equals("") || x1==null || x2.equals("") || x2==null||
//				isNumeric==false || isNumeric2==false) {
//			error="error";
//			model.addAttribute("result",error);
//			return "input";
//		}
//
//		int xx1=Integer.parseInt(x1);
//		int xx2=Integer.parseInt(x2);
//		int result=xx1*xx2;
//		model.addAttribute("result",result);
//		if(result>20)return "calc";
//		else if(result<=20) return "input"; 
//		
//		
//		return "input";
		try {
		String x1=hsr.getParameter("x1");
		String x2=hsr.getParameter("x2");
		
		int xx1=Integer.parseInt(x1);
		int xx2=Integer.parseInt(x2);
		int result=xx1*xx2;
		model.addAttribute("result",result);
		if(result>20)return "calc";
		else if(result<=20) return "input"; 
		}catch (Exception e) {
			model.addAttribute("result","error");
			return "input";
		}
		return "input";
	}

	@RequestMapping("/incalc")
	public String incalc(HttpServletRequest hsr,Model model) {
		try {
			String x1=hsr.getParameter("x1");
			String x2=hsr.getParameter("x2");
			String op=hsr.getParameter("op");			
			int xx1=Integer.parseInt(x1);
			int xx2=Integer.parseInt(x2);
			
			if(op.equals("+")) {
				model.addAttribute("result",(xx1+xx2));return "plus";
			}else if(op.equals("-")) {
				model.addAttribute("result",(xx1-xx2));return "minus";
			}else if(op.equals("*")) {
				model.addAttribute("result",(xx1*xx2));return "multi";
			}else if(op.equals("/")) {
				model.addAttribute("result",(xx1/xx2));return "divide";
			}else {
				model.addAttribute("result","������ �Ҹ�");
				return "error";
			}
			
			}catch (Exception e) {
				model.addAttribute("result","���� Ȯ��");
				return "error";
			}
			
	}
	
}
