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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class MyController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/deleteRoom")
	public String doDeleteRoom(HttpServletRequest hsr) {
		int roomcode=Integer.parseInt(hsr.getParameter("roomcode"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		emp.deleteRoom(roomcode);
		return "redirect:/ad_room";
		}
	
	@RequestMapping("/deleteMenu")
	public String doDeleteMenu(HttpServletRequest hsr) {
		int code=Integer.parseInt(hsr.getParameter("code"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		emp.deleteMenu(code);
		return "redirect:/menuadd";
		}
	@ResponseBody
	@RequestMapping(value="/roomlist",method=RequestMethod.GET,
            produces="application/json;charset=utf-8")
	public String roomlist() {
		iEmp jc=sqlSession.getMapper(iEmp.class);
		ArrayList<Room> Room=jc.getRoom();
		JSONArray ja=new JSONArray();
		for(int i=0;i<Room.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("roomcode", Room.get(i).getRoomcode());
			jo.put("name", Room.get(i).getName());
			jo.put("type", Room.get(i).getType());
			jo.put("howmany", Room.get(i).getHowmany());
			jo.put("howmuch", Room.get(i).getHowmuch());
			ja.add(jo);
		}
		return ja.toString();
		}
	@ResponseBody
	@RequestMapping(value="/roomtypelist",method=RequestMethod.GET,
            produces="application/json;charset=utf-8")
	public String roomtypelist(){
	iEmp jc=sqlSession.getMapper(iEmp.class);
	ArrayList<Roomtype> typelist=jc.getRoomType();
	JSONArray ja=new JSONArray();
	for(int i=0;i<typelist.size();i++) {
		JSONObject jo=new JSONObject();
		jo.put("name", typelist.get(i).getName());
		jo.put("typecode", typelist.get(i).getTypecode());
		ja.add(jo);
	}
	return ja.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/emplist",method=RequestMethod.GET,
            produces="application/json;charset=utf-8")
	public String emplist(HttpServletRequest hsr){
		String keyword = hsr.getParameter("kw");
	      if(keyword.equals("")) return "";
	      
	      iEmp jc = sqlSession.getMapper(iEmp.class);
	      ArrayList<emplist> typelist = jc.getEmpList1(Integer.parseInt(keyword));
		
		//¹öÆ°´­·¶À»¶§ ÀüºÎ Ç¥½Ã
//	iEmp jc=sqlSession.getMapper(iEmp.class);
//	ArrayList<emplist> typelist=jc.emplist();
//	
	JSONArray ja=new JSONArray();
	for(int i=0;i<typelist.size();i++) {
		JSONObject jo=new JSONObject();
		jo.put("id", typelist.get(i).getEmployee_id());
		jo.put("name", typelist.get(i).getEmp_name());
		jo.put("mobile", typelist.get(i).getPhone_number());
		jo.put("manager", typelist.get(i).getManager_id());
		jo.put("hire", typelist.get(i).getHire_date());
		
		ja.add(jo);
	}
	return ja.toString();
	}
	
	@RequestMapping("/ad_room")public String adroom() {return "addRoom";}
	@RequestMapping("/art")public String ART() {return "addRoomtype";}
	@RequestMapping("/admenu")public String addm() {return "addMenu";}
	@RequestMapping("empl")public String empl() {return "emplist";}
	@ResponseBody
	@RequestMapping(value="/menulist",method=RequestMethod.GET,
            produces="application/json;charset=utf-8")
	public String doMenuadd(HttpServletRequest hsr,Model m) {
		iEmp jc=sqlSession.getMapper(iEmp.class);
		ArrayList<menu> menu=jc.getmenu();
		JSONArray ja=new JSONArray();
		for(int i=0;i<menu.size();i++) {
			JSONObject jo=new JSONObject();
			jo.put("name", menu.get(i).getName());
			jo.put("price", menu.get(i).getPrice());
			jo.put("code", menu.get(i).getCode());
			ja.add(jo);
		}
//		m.addAttribute("menu",menu);
//		return "addMenu";
		return ja.toString();
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
		String StrCode=hsr.getParameter("roomcode");
		String name=hsr.getParameter("roomname");
		int type=Integer.parseInt(hsr.getParameter("roomtype"));
		int howmany=Integer.parseInt(hsr.getParameter("howmany"));
		int howmuch=Integer.parseInt(hsr.getParameter("howmuch"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		if(StrCode.equals("")) { //insert
		emp.addRoom(name, type, howmany, howmuch);
		}else {
			int code=Integer.parseInt(StrCode);
			emp.updateRoom(code,name,type,howmany,howmuch);
		}
		return "redirect:/ad_room";
	}
	
	
	
	@RequestMapping("/addmenu")
	public String doAddMenu(HttpServletRequest hsr) {
		String strCode=hsr.getParameter("code");
		String mname=hsr.getParameter("menu_name");
		int price=Integer.parseInt(hsr.getParameter("price"));
		
		iEmp emp=sqlSession.getMapper(iEmp.class);
		if(strCode.equals("")) { //insert
		emp.addMenu(mname, price);
		}else { //update
			int code=Integer.parseInt(strCode);
			emp.updateMenu(code, mname, price);
		}
		return "redirect:/menuadd";
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
				model.addAttribute("result","ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ò¸ï¿½");
				return "error";
			}
			
			}catch (Exception e) {
				model.addAttribute("result","ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½");
				return "error";
			}
			
	}
	
}
