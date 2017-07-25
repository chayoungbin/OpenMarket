package relative;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class relativeDAO {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public relativeDAO(){try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){e.printStackTrace();}}	
	public void connect(){try{conn = DriverManager.getConnection("jdbc:mysql://localhost/Prediction","root","1234");stmt = conn.createStatement();}catch(Exception e){e.printStackTrace();}}
	public void disconnect(){if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}}
	//DB연결 코드
}
