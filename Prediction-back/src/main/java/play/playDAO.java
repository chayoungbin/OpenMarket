package play;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import team_record.team_recordVO;

public class playDAO {

	@Autowired
    private SqlSession sqlSession;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String pre_result ="";
	List<Object> predict;
	int prediction;
	
	public playDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
	
	public String play_predict(String matchday,String home,String away){
		try{
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
	
	//public String practice(String matchday,String home,String away){
	//	playVO pvo1 = new playVO(matchday,home,away);
	//	pre_result = sqlSession.selectOne("selectMapper.select_prediction",pvo1);
	//	return pre_result;
	//}
}
