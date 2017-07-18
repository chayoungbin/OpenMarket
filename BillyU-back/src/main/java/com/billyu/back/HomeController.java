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
	//sqlsession 
	
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
	
	@RequestMapping(value="/DeleteUser")
	public String deleteUser(HttpServletRequest request){
		String delete_user = request.getParameter("delete_user");
		try{
			sqlSession1.delete("remove",delete_user);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	return "Back_Main";
	}
	
	@RequestMapping(value="/InsertUser")
	public String insertUser(HttpServletRequest request){
		try{
		String insert_nickname = request.getParameter("insert_nickname");
		String insert_usernumber = request.getParameter("insert_usernumber");
		userDTO dto = new userDTO(insert_nickname, insert_usernumber);
		sqlSession1.insert("add",dto);
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return "Back_Main";
	}
	
	@RequestMapping(value="/UpdateUser")
	public String updateUser(HttpServletRequest request){
	try{
		userDTO dto = new userDTO("asd","1234");
		sqlSession1.update("update",dto);
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return "Back_Main";
	}//
	
	@RequestMapping(value="/Back_Main")
	public String Back_Main(){return "Back_Main";}
	@RequestMapping(value="/DeleteUserForm")
	public String DeleteUserFrom(){return "user/DeleteUserForm";}
	@RequestMapping(value="/InsertUserForm")
	public String InsertUserFrom(){return "user/InsertUserForm";}
	@RequestMapping(value="/SelectUserForm")
	public String SelectUserFrom(Model model){
		//List<HashMap<String, String>> selectUser = sqlSession1.selectList("userControlMapper.selectUser");
        //model.addAttribute("SelectUser", selectUser.toString());
        
        List<userDTO> list = sqlSession1.selectList("selectUser");
        for(userDTO dto: list){
        	model.addAttribute("nick",dto.getNickname());
        	model.addAttribute("usernum",dto.getUsernumber());
        }
        //model.addAttribute("list",list.toString());
		return "user/SelectUserForm";}
	@RequestMapping(value="/UpdateUserForm")
	public String UpdateUserFrom(){return "user/UpdateUserForm";}
	
}
