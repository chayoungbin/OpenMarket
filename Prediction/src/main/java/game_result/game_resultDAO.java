package game_result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import play.playDTO;

public class game_resultDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public game_resultDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
	
	ArrayList<game_resultDTO> game_matchday_list = new ArrayList<game_resultDTO>();
	public ArrayList<game_resultDTO> game_matchday_list(){
		try{
			connect();
			String sql = "select distinct matchday from game_result order by matchday desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matchday = rs.getString("matchday");
				game_resultDTO gd = new game_resultDTO(matchday);
				game_matchday_list.add(gd);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return game_matchday_list;
	}
	
	ArrayList<game_resultDTO> game_result = new ArrayList<game_resultDTO>();
	public ArrayList<game_resultDTO> game_result_list(String matchday){
		try{
			connect();
			String sql = "select * from game_result where matchday='"+matchday+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String game_matchday = rs.getString("matchday");
				String game_home = rs.getString("home");
				String game_away = rs.getString("away");
				int game_home_s = rs.getInt("home_score");
				int game_away_s = rs.getInt("away_score");
				String game_forecate = rs.getString("forecate");
				game_resultDTO gd = new game_resultDTO(game_matchday, game_home, game_away, game_home_s, game_away_s, game_forecate);
				game_result.add(gd);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return game_result;
	
	}
}
