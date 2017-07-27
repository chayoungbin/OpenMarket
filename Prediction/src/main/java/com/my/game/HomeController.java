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
import team.teamDTO;
import team_record.team_recordDTO;

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
		String better = null;
		if(win > lose){
			better = "홈우세";
		}else if(win < lose){
			better = "원정우세";
		}else{
			better = "백중세";
		}
		model.addAttribute("better",better);
		model.addAttribute("home",hometeam);
		model.addAttribute("away",awayteam);
		model.addAttribute("win",win);
		model.addAttribute("lose",lose);
		model.addAttribute("draw",draw);
		//여기까지는 상대전적 가져오는 거였습니다.
		
		List<teamDTO> tList = sqlSession.selectList("select_team",hometeam);
		teamDTO team_home = tList.get(0);
		int home_rank = team_home.getRank();
		double home_win_rate = team_home.getWin();
		int home_score_success = team_home.getScore_s();
		int home_score_fail = team_home.getScore_f();
		
		model.addAttribute("home_rank",home_rank);
		model.addAttribute("home_win_rate",home_win_rate);
		model.addAttribute("home_score_success",home_score_success);
		model.addAttribute("home_score_fail",home_score_fail);
		//team테이블에서 가져온 정보(홈)
				
		List<teamDTO> tList2 = sqlSession.selectList("select_team",awayteam);
		teamDTO team_away = tList2.get(0);
		int away_rank = team_away.getRank();
		double away_win_rate = team_away.getWin();
		int away_score_success = team_away.getScore_s();
		int away_score_fail = team_away.getScore_f();
		
		model.addAttribute("away_rank",away_rank);
		model.addAttribute("away_win_rate",away_win_rate);
		model.addAttribute("away_score_success",away_score_success);
		model.addAttribute("away_score_fail",away_score_fail);
		//team테이블에서 가져온 정보(원정)
		
		List<team_recordDTO> trList = sqlSession.selectList("select_teamrecord",hometeam);
		team_recordDTO teamrecord_home = trList.get(0);
		double home_streak = teamrecord_home.getStreak();
		int home_win = teamrecord_home.getWin();
		int home_draw = teamrecord_home.getDraw();
		int home_lose = teamrecord_home.getLose();
		
		model.addAttribute("home_streak",home_streak);
		model.addAttribute("home_win",home_win);
		model.addAttribute("home_draw",home_draw);
		model.addAttribute("home_lose",home_lose);
		//team테이블에서 가져온 정보(홈)
		
		List<team_recordDTO> trList2 = sqlSession.selectList("select_teamrecord",awayteam);
		team_recordDTO teamrecord_away = trList2.get(0);
		double away_streak = teamrecord_away.getStreak();
		int away_win = teamrecord_away.getWin();
		int away_draw = teamrecord_away.getDraw();
		int away_lose = teamrecord_away.getLose();
		
		model.addAttribute("away_streak",away_streak);
		model.addAttribute("away_win",away_win);
		model.addAttribute("away_draw",away_draw);
		model.addAttribute("away_lose",away_lose);
		//team테이블에서 가져온 정보(원정)
		
		return "detail_relative";
	}
	//단순맵핑
	@RequestMapping("/Main")public String Main(){return "Main";}
	@RequestMapping("/Navbar")public String Navbasr(){return "Navbar";}
}
