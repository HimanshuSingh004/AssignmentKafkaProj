package JavaKafka.KafkaProj;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoreData 
{
	/*
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kafkadata","root","");
			Statement st=con.createStatement();
			String var="khdbfk";
			String var2="j,hzbfk";
			String sql="insert into kafkamsg values('"+var+"','"+var2+"')";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.executeUpdate();
			String ssql="Select * from kafkamsg";
			ResultSet rs=st.executeQuery(ssql);
			while(rs.next())
			{
				System.out.print(rs.getString("key"));
				System.out.print(" ");
				System.out.println(rs.getString("value"));
			}
			System.out.println("Doone");		
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public static void savedata(String key,String value, long offset,int part)
	{
		try {
			//to connect to my sql
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kafkadata","root","");
			Statement st=con.createStatement();
			String select="select count(*) id1 from kafkamsg";
			ResultSet rs=st.executeQuery(select);
			
			int id=0;
			while(rs.next())
			{
				id=Integer.parseInt(rs.getString("id1"));
			}
			id++;
			
			//Insert query
			String sql="insert into kafkamsg values('"+id+"','"+key+"','"+value+"','"+offset+"','"+part+"')";
			PreparedStatement ps=con.prepareStatement(sql);
			
			//query to update table
			ps.executeUpdate();
			
			//Connection close
			con.close();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
