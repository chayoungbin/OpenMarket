package com.billyu.back;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import user.userDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    private SqlSession sqlSession1;
	//sqlsession 등록
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		return "Back_Main";
	}
	//default 페이지
	@RequestMapping(value="/user/SelectUser")
	public String selectUser(Model model){
		//List<HashMap<String, String>> selectUser = sqlSession1.selectList("userControlMapper.selectUser");
        //model.addAttribute("SelectUser", selectUser.toString());
        
        List<userDTO> list = sqlSession1.selectList("selectUser");
        model.addAttribute("list",list.toString());
		return "user/SelectUserForm";
	}//유저목록보기
	
	@RequestMapping(value="/user/DeleteUser")
	public String deleteUser(){
		String id ="1234";
		try{
			sqlSession1.delete("remove",id);	
			sqlSession1.close();	//	세션닫기	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return "Back_Main";
	}//유저삭제
	
	@RequestMapping(value="/user/InsertUser")
	public String insertUser(HttpServletRequest request){
		try{
		String insert_nickname = request.getParameter("insert_nickname");
		String insert_usernumber = request.getParameter("insert_usernumber");
		userDTO dto = new userDTO(insert_nickname, insert_usernumber);
		sqlSession1.insert("add",dto);
		sqlSession1.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return "Back_Main";
	}//유저등록
	
	@RequestMapping(value="/UpdateUser")
	public String updateUser(){
	try{
			userDTO dto = new userDTO("영뷘","1234");
		sqlSession1.update("update",dto);
		sqlSession1.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return "Back_Main";
	}//
	
	//단순 페이지 맵핑
	@RequestMapping(value="/user/DeleteUserForm")
	public String DeleteUserFrom(){return "user/DeleteUserForm";}
	@RequestMapping(value="/user/InsertUserForm")
	public String InsertUserFrom(){return "user/InsertUserForm";}
	@RequestMapping(value="/user/SelectUserForm")
	public String SelectUserFrom(){return "user/SelectUserForm";}
	@RequestMapping(value="/user/UpdateUserForm")
	public String UpdateUserFrom(){return "user/UpdateUserForm";}
	
}
