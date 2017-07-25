package com.my.back;

import java.text.DateFormat;



import java.util.*;
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

import game_result.game_resultVO;
import play.playDAO;
import play.playVO;
import relative.relativeVO;
import team.teamVO;
import team_record.team_recordDAO;
import team_record.team_recordVO;
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
	@RequestMapping(value="/result_game")
	public String result_game(HttpServletRequest request,Model model){
		String matchday = request.getParameter("matchday"); //경기날짜
		String home = request.getParameter("home"); //홈팀
		String away = request.getParameter("away"); //원정팀
		String s_home_score = request.getParameter("homescore"); //홈팀득점 , 어웨이실점
		String s_away_score = request.getParameter("awayscore"); //어웨이득점 , 홈팀실점
		if(s_home_score == null){s_home_score = "0";} //예외처리
		if(s_away_score == null){s_away_score = "0";} //예외처리
		int home_score = Integer.parseInt(s_home_score); //int타입으로 득점정보 가져옴
		int away_score = Integer.parseInt(s_away_score);
		relativeVO rVO = new relativeVO(home, away);
		
		//double home_streak = sqlSession.selectOne("selectMapper.select_streak",home);
		//double away_streak = sqlSession.selectOne("selectMapper.select_streak",away);
		//일단 안되니깐 DAO객체로 돌립니다.
		team_recordDAO rDAO= new team_recordDAO();
		double home_streak = rDAO.select_streak(home);
		double away_streak = rDAO.select_streak(away);
		
		String forecate; //예측뭐햇는지
		playDAO pDAO = new playDAO(); //playDAO객체 생성
		String pre_result = pDAO.play_predict(matchday, home, away);
		//String pre_result = pDAO.practice(matchday, home, away);
		
		//play테이블에서 경기날짜,홈팀,어웨이팀이 같은 예측을 가져옴
		if(home_score > away_score && pre_result.equals("home")){
			forecate = "Success"; // 예측이 맞으면 
		}else if(home_score < away_score && pre_result.equals("away")){
			forecate = "Success"; 
		}else if(home_score == away_score && pre_result.equals("draw")){
			forecate = "Success";
		}else{
			forecate="Fail"; //예측이 틀리면
		}
		//경기 결과를 game_result테이블에 넣은작업
		if(home_score > away_score){
			sqlSession.update("win",home);
			sqlSession.update("lose",away); //승패업데이트
			sqlSession.update("relative_homewin",rVO);
			sqlSession.update("relative_awaylose",rVO); //상대전적 업데이트
			if(home_streak > 0){
				sqlSession.update("streak_wining",home);
			}else{
				sqlSession.update("streak_newwin",home);
			}
			if(away_streak < 0){
				sqlSession.update("streak_losing",away);
			}else{
				sqlSession.update("streak_newlose",away);
			}//연속승리,패배 업데이트
		} // 홈승리
		if(home_score < away_score){
			sqlSession.update("win",away);
			sqlSession.update("lose",home); //승패 업데이트
			sqlSession.update("relative_awaywin",rVO);
			sqlSession.update("relative_homelose",rVO); //상대전적 업데이트
			if(away_streak > 0){
				sqlSession.update("streak_wining",away);
			}else{
				sqlSession.update("streak_newwin",away);
			}
			if(home_streak < 0){
				sqlSession.update("streak_losing",home);
			}else{
				sqlSession.update("streak_newlose",home);
			}//연속승리,패배 업데이트
		} //원정승리
		if(home_score == away_score){
			sqlSession.update("draw",home);
			sqlSession.update("draw",away);
			sqlSession.update("relative_draw",rVO);
		}//무승부
		teamVO teamVO_home = new teamVO(home, home_score, away_score);
		teamVO teamVO_away = new teamVO(away, away_score, home_score);
		
		sqlSession.update("addscore",teamVO_home);
		sqlSession.update("addscore",teamVO_away);
		
		game_resultVO resultVO = new game_resultVO(matchday, home, away, home_score, away_score,forecate);
		sqlSession.insert("insert_result",resultVO);
		//게임결과저장
		return "InputResult";
	}//game_result테이블에 결과 저장
	
	@RequestMapping(value="/UpdateWin")
	public String content_update(HttpServletRequest request){
		List<team_recordVO> list = sqlSession.selectList("selectMapper.select_team_record");
		for(int i=0;i<list.size();i++) {
			team_recordVO dto = list.get(i);
			String club_name = dto.getClub_name();
			int total = dto.getTotal();
			int win = dto.getWin();
			int draw = dto.getDraw();
			int lose = dto.getLose();
			double win_rate = (double)win/((double)total-(double)draw);
			teamVO tv = new teamVO(club_name, win_rate, 1);
			sqlSession.update("add_winrate",tv);
		}
		return "UpdateWin";
	}//승률계산후 업데이트
	@RequestMapping("/ArrayLank")
	public String ArrayLank(){
		List<teamVO> rank = sqlSession.selectList("selectMapper.select_team");
		for(int i=0;i<rank.size();i++){
			teamVO dto = rank.get(i);
			String club_name = dto.getClub_name();
			double win_rate = dto.getWin_rate();
			teamVO tv = new teamVO(club_name, win_rate, i+1);
			sqlSession.update("rank_update",tv);
		}
		return "ArrayLank";
	}//순위 정렬하기
	@RequestMapping("/today")
	public String today(HttpServletRequest request){
		String matchday = request.getParameter("matchday"); 
		String home = request.getParameter("home"); 
		String away = request.getParameter("away"); 
		String prediction = request.getParameter("prediction");
		playVO pVO = new playVO(matchday, home, away, prediction);
		sqlSession.insert("insert_play",pVO);
		
		return "todayMatch";
	}//오늘의 경기등록 ,play테이블에 저장

	@RequestMapping("/Information")
	public String Information(HttpServletRequest request,Model model){
		String home = request.getParameter("home");
		String away = request.getParameter("away");
		double prediction_home = 0.0; //홈이 이길 확률
		double prediction_away = 0.0; //원정이 이길 확률
		
		relativeVO reVO = new relativeVO(home, away);
		
		List<relativeVO> relative_record = sqlSession.selectList("selectMapper.select_relative",reVO);
			relativeVO dto = relative_record.get(0);
			int win = dto.getWin();
			int lose = dto.getLose();
			int tie = dto.getTie();
			//상대전적 가져옴
			
		List<teamVO> hometeam_list = sqlSession.selectList("selectMapper.select_hometeam_list",home);
			teamVO tVO = hometeam_list.get(0);
			double homewin_rate = tVO.getWin(); //홈팀승률
			int homescore_success = tVO.getScore_s(); //홈팀득점
			int homescore_fail = tVO.getScore_f(); //홈팀실절
			//홈팅 승률 및 득실점 가져옴
			
		List<teamVO> awayteam_list = sqlSession.selectList("selectMapper.select_awayteam_list",away);
			teamVO tVO2 = awayteam_list.get(0);
			double awaywin_rate = tVO.getWin(); //원정팀승률
			int awayscore_success = tVO.getScore_s(); //원정팀득점
			int awayscore_fail = tVO.getScore_f(); //원정팀실절
			//원정팀 승률 및 득실점 가져옴
			
		List<team_recordVO> hometeam_record = sqlSession.selectList("selectMapper.select_hometeam_record",home);
			team_recordVO rVO = hometeam_record.get(0);
			double home_streak = rVO.getStreak(); //연승,연패
			int home_total = rVO.getTotal(); //총경기수
			//홈팀 기록 가져옴
			
		List<team_recordVO> awayteam_record = sqlSession.selectList("selectMapper.select_awayteam_record",away);
			team_recordVO rVO2 = awayteam_record.get(0);
			double away_streak = rVO2.getStreak();
			int away_total = rVO2.getTotal();
			//원정팀 기록 가져옴	
						
			prediction_home = prediction_home + ((((double)win/((double)win+(double)lose+(double)tie))*100)*0.2)+(homewin_rate*10)+((double)homescore_success/(double)home_total)-((double)homescore_fail/(double)home_total)+home_streak;
			prediction_away = prediction_away + ((((double)lose/((double)win+(double)lose+(double)tie))*100)*0.2)+(awaywin_rate*10)+((double)awayscore_success/(double)away_total)-((double)awayscore_fail/(double)away_total)+away_streak;
			
			model.addAttribute("home_rate",prediction_home);
			model.addAttribute("away_rate",prediction_away);
			
			if(prediction_home > prediction_away){
				model.addAttribute("result","홈승");
			}else if(prediction_home < prediction_away){
				model.addAttribute("result","원정승");
			}else{
				model.addAttribute("result","무승부");
			}
		return "Information";
	}//승부예측하기(핵심이야)
	
	//여기는 단순맵핑
	@RequestMapping("/Main")public String main(){return "Main";}
	@RequestMapping("/InputResult")public String InputResult(){return "InputResult";}
	@RequestMapping("/todayMatch")public String todayMatch(){return "todayMatch";}
	
}
