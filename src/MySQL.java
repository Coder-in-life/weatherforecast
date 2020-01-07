import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQL {
	
	//创建连接
	@SuppressWarnings("finally")
	public  Connection connection() {
		Connection conn=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","zheng.100189022");
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception E) {
			E.printStackTrace();
		}finally {
			return conn;
		}
	}
	
	@SuppressWarnings("finally")
	public  Connection connection(String str) {
		Connection conn=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306"+"/"+str+"?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","zheng.100189022");
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception E) {
			E.printStackTrace();
		}finally {
			return conn;
		}
	}
	
	//创建新的数据库
	public  void CreateDatabase(String name) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement statement=null;
		ResultSet rs=null;
		conn=connection();
		try {
			statement =conn.createStatement();
			String sql="CREATE DATABASE "+name+" DEFAULT CHARACTER SET utf8mb4";
			statement.executeUpdate(sql);
		}	catch(Exception e) {
			e.printStackTrace();
		}	finally {
			close(conn,statement,rs,stmt);
		}
	}
	
	//在数据库中创建新的表单
	public  void CreateTable(String DatabaseName,String sql) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement statement=null;
		ResultSet rs=null;
		conn=connection(DatabaseName);
		try {
			statement=conn.createStatement();
			statement.execute(sql);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,statement,rs,stmt);
		}
	}

	//向表单中插入数据
	public  void Insert(String DatabaseName,ArrayList<City> city) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement st=null;
		ResultSet rs=null;
		conn=connection(DatabaseName);
		for (int i=0;i<city.size();i++) {
			City index=city.get(i);
			try {
				String sql="insert into city values (?,?)";
				stmt=(PreparedStatement)conn.prepareStatement(sql);
				stmt.setString(1,index.cityname);
				stmt.setInt(2,index.citynum);
				stmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			}
			
			for (int j=0;j<4;j++) {
				Forecast index2=index.forecast[j];
				try {
					String sql="insert into weather values (?,?,?,?,?,?,?,?,?,?,?)";
					stmt=(PreparedStatement)conn.prepareStatement(sql);
					stmt.setInt(1,index.citynum*10+j+1);
					stmt.setString(2,index2.date);
					stmt.setString(3,index2.week);
					stmt.setString(4,index2.dayweather);
					stmt.setString(5,index2.nightweather);
					stmt.setString(6,index2.daytemp);
					stmt.setString(7,index2.nighttemp);
					stmt.setString(8,index2.daywind);
					stmt.setString(9,index2.nightwind);
					stmt.setString(10,index2.daypower);
					stmt.setString(11,index2.nightpower);
					stmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
				}
			}
		}
		close(conn,st,rs,stmt);
	}
	
	//更新天气信息
	public void Update(String DatabaseName,ArrayList<City> city) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement st=null;
		ResultSet rs=null;
		conn=connection(DatabaseName);
		for (int i=0;i<city.size();i++) {
			City index=city.get(i);
			for (int j=0;j<4;j++) {
				Forecast index2=index.forecast[j];
				try {
					String sql="update weather set date=?,week=?,dayweather=?,nightweather=?,daytemp=?,nighttemp=?,daywind=?,nightwind=?,daypower=?,nightpower=? where id=?";
					stmt=(PreparedStatement)conn.prepareStatement(sql);
					stmt.setString(1,index2.date);
					stmt.setString(2,index2.week);
					stmt.setString(3,index2.dayweather);
					stmt.setString(4,index2.nightweather);
					stmt.setString(5,index2.daytemp);
					stmt.setString(6,index2.nighttemp);
					stmt.setString(7,index2.daywind);
					stmt.setString(8,index2.nightwind);
					stmt.setString(9,index2.daypower);
					stmt.setString(10,index2.nightpower);
					stmt.setInt(11,index.citynum*10+j+1);
					stmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
				}
			}
		}
		close(conn,st,rs,stmt);
	}
	
	/*查找天气信息
	 cityname：城市名
	 day：查询的时间（1为今天，2为明天，以此类推）
	 */
	public void Search(String DatabaseName,String cityname,int day) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement st=null;
		ResultSet rs=null;
		conn=connection(DatabaseName);
		int citynum=0;
		try {
			String sql="select * from city where CityName=?";
			stmt=(PreparedStatement)conn.prepareStatement(sql);
			stmt.setString(1,cityname);
			rs=stmt.executeQuery();
			if (rs.next()) {
				citynum=rs.getInt("CityNum");
				sql="select * from weather where id=?";
				stmt=(PreparedStatement)conn.prepareStatement(sql);
				stmt.setInt(1,citynum*10+day);
				rs=stmt.executeQuery();
				if(rs.next()) {
					System.out.println("日期:"+rs.getString("date"));
					System.out.println("星期:"+rs.getString("week"));
					System.out.println("白天天气:"+rs.getString("dayweather"));
					System.out.println("夜晚天气:"+rs.getString("nightweather"));
					System.out.println("白天温度:"+rs.getString("daytemp"));
					System.out.println("夜晚温度:"+rs.getString("nighttemp"));
					System.out.println("白天风向:"+rs.getString("daywind"));
					System.out.println("夜晚风向:"+rs.getString("nightwind"));
					System.out.println("白天风力:"+rs.getString("daypower"));
					System.out.println("夜晚风力:"+rs.getString("nightpower"));
				}
			}else {
				System.out.print("输入城市名错误，请参照城市名称表");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,st,rs,stmt);
		}
	}
	
	//关闭资源
	public static void close(Connection conn,Statement st,ResultSet rs,PreparedStatement ps) {
		if (rs!=null) {
			try {
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (st!=null) {
			try {
				st.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (conn!=null) {
			try {
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (ps!=null) {
			try {
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
