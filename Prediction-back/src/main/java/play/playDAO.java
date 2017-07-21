package play;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import team_record.team_recordVO;

public class playDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String pre_result;
	int prediction;
	
	public playDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
	
	public String play_predict(String matchday,String home,String away){
		try{
			//if(home_score>away_score){
			//	pre_result="home";
			//}
			//if(home_score<away_score){
			//	pre_result="away";
			//}
			//if(home_score == away_score){
			//	pre_result="draw";
			//}
			connect();
			String sql = "select prediction from play where matchday='"+matchday+"' and home='"+home+"' and away='"+away+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				pre_result = rs.getString("prediction");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return pre_result;
	}
}
