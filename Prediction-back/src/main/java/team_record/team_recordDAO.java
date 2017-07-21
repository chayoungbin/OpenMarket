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
	
	ArrayList<team_recordVO> team_record_list = new ArrayList<team_recordVO>();
	team_recordVO tr;
	public ArrayList<team_recordVO> team_record_list(){
		try{
			connect();
			String sql = "select * from team_record";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String club_name = rs.getString("club_name"); //구단명
				int streak = rs.getInt("streak"); //연승
				int total = rs.getInt("total");
				int win = rs.getInt("win");
				int draw = rs.getInt("draw");
				int lose = rs.getInt("lose");
				
				tr = new team_recordVO(club_name, streak, total, win, draw, lose);
				team_record_list.add(tr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return team_record_list;
	}
}
