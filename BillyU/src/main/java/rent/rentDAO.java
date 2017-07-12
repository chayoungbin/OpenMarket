package rent;

import java.sql.*;
import java.util.ArrayList;

import product.proDTO;

public class rentDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	rentDTO dto;
	ArrayList<rentDTO> rent_list = new ArrayList<rentDTO>();
	ArrayList<rentDTO> rent_list2 = new ArrayList<rentDTO>();
	int count=0;
	String msg="";
	public rentDAO(){
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void connect(){
		try{
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/billyu",
					"root",
					"1234"
					);		
			stmt = conn.createStatement();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public void disconnect(){
		if(stmt != null){try{stmt.close();}catch(Exception e){e.printStackTrace();}}
		if(conn != null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
	}
	

	public void insert_rent(String productguest,int productnumber,String message,String startdate,String enddate,int totalprice){
		connect();
		try{
			String sql="insert into rent(productguest,productnumber,message,startdate,enddate,totalprice) values('"+productguest+"',"+productnumber+",'"+message+"','"+startdate+"','"+enddate+"',"+totalprice+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public String select_rent(int productnumber){
		connect();
		String nickname="";
		try{
			String sql="select nickname from product where productnumber='"+productnumber+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				nickname = rs.getString("nickname");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return nickname;
	}
	
	public void insert_nickname(String nickname,String productguest,int productnumber){
		connect();
		try{
			String sql="update rent set producthost='"+nickname+"' where productguest='"+productguest+"' and productnumber="+productnumber+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public ArrayList<rentDTO> rent_list(String nickname){
		try{
			connect();
			String sql = "select * from rent where producthost='"+nickname+"' order by rentnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){

				int rentnumber = rs.getInt("rentnumber");
				String producthost = rs.getString("producthost");
				String productguest = rs.getString("productguest");
				int productnumber = rs.getInt("productnumber");
				String startdate = rs.getString("startdate");
				String enddate = rs.getString("enddate");

				String message = rs.getString("message");
				int totalprice = rs.getInt("totalprice");
				Timestamp curtime = rs.getTimestamp("curtime");
				String flag = rs.getString("flag");

				dto = new rentDTO(rentnumber, producthost, productguest, productnumber, startdate, enddate, message, totalprice,curtime,flag);
				rent_list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list;
	}
	
	public ArrayList<rentDTO> rent_list2(String nickname){
		try{
			connect();
			String sql = "select * from rent where productguest='"+nickname+"' order by rentnumber desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){

				int rentnumber = rs.getInt("rentnumber");
				String producthost = rs.getString("producthost");
				String productguest = rs.getString("productguest");
				int productnumber = rs.getInt("productnumber");
				String startdate = rs.getString("startdate");
				String enddate = rs.getString("enddate");

				String message = rs.getString("message");
				int totalprice = rs.getInt("totalprice");
				Timestamp curtime = rs.getTimestamp("curtime");
				String flag = rs.getString("flag");

				dto = new rentDTO(rentnumber, producthost, productguest, productnumber, startdate, enddate, message, totalprice,curtime,flag);
				rent_list2.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		
		return rent_list2;
	}
	public void delete_rent(int rentnumber){
		connect();
		try{
			String sql="delete from rent where rentnumber="+rentnumber+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public int count_flag(String id){
		connect();
		try{
			String sql="select count(flag) from rent where producthost='"+id+"' and flag='no'";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return count;
	}
	
	public void update_flag(int rentnumber){
		connect();
		try{
			String sql="update rent set flag='yes' where rentnumber ="+rentnumber+"";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
	}
	
	public String message_view(int rentnumber){
		connect();
		try{
			String sql="select message from rent where rentnumber="+rentnumber+"";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				msg=rs.getString(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{disconnect();}
		return msg;
	}
}
