package team_record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class team_recordDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public team_recordDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
	double streak;
	
	public double select_streak(String teamName){
		try{
			connect();
			String sql = "select streak from team_record where club_name = '"+teamName+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				streak = rs.getDouble("streak"); //연속승/연속패
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return streak;
	}
}
