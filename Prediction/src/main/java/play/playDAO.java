package play;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class playDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public playDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
	
	ArrayList<playDTO> pDTO = new ArrayList<playDTO>();
	public ArrayList<playDTO> play_list(String match){
		try{
			connect();
			String sql = "select * from play where matchday='"+match+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matchday = rs.getString("matchday");
				String home = rs.getString("home");
				String away = rs.getString("away");
				String prediction = rs.getString("prediction");
				
				playDTO pd = new playDTO(matchday, home, away, prediction);
				pDTO.add(pd);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return pDTO;
	}
	
	ArrayList<playDTO> matchday_list = new ArrayList<playDTO>();
	public ArrayList<playDTO> matchday_list(){
		try{
			connect();
			String sql = "select distinct matchday from play order by matchday desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matchday = rs.getString("matchday");
				playDTO pd = new playDTO(matchday);
				matchday_list.add(pd);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return matchday_list;
	}
}
