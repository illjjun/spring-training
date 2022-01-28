package com.human.train;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

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
		String error="";
		
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
				model.addAttribute("result","연산자 불명");
				return "error";
			}
			
			}catch (Exception e) {
				model.addAttribute("result","숫자 확인");
				return "error";
			}
			
	}
	
}
