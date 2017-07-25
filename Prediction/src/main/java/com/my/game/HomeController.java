package com.my.game;

import java.util.*;
import java.text.DateFormat;
import java.util.Date;
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

import relative.relativeDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    private SqlSession sqlSession;
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
		
		//List<HashMap<String, String>> outputs = sqlSession.selectList("userControlMapper.selectSample");
        //model.addAttribute("showDB", outputs.toString());
		
		return "Main";
	}
	@RequestMapping("/ShowResult")
	public String ShowResult(){
		return "ShowResult";
	}
	@RequestMapping("/ShowForecate")
	public String ShowForecate(){
		return "ShowForecate";
	}
	@RequestMapping("/detail_team")
	public String detail_team(){
		return "detail_team";
	}
	@RequestMapping("/detail_relative")
	public String detail_relative(Model model,HttpServletRequest request){
		String hometeam = request.getParameter("home");
		String awayteam = request.getParameter("away");
		
		relativeDTO rDTO = new relativeDTO(hometeam, awayteam);
		List<relativeDTO> rList = sqlSession.selectList("select_relative",rDTO);
		relativeDTO relation = rList.get(0);
		int win = relation.getWin();
		int lose = relation.getLose();
		int draw = relation.getTie();
		
		model.addAttribute("win",win);
		model.addAttribute("lose",lose);
		model.addAttribute("draw",draw);
		return "detail_relative";
	}
	//단순맵핑
	@RequestMapping("/Main")public String Main(){return "Main";}
	@RequestMapping("/Navbar")public String Navbasr(){return "Navbar";}
	
}
