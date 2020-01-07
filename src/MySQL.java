import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQL {
	
	//��������
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
	
	//�����µ����ݿ�
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
	
	//�����ݿ��д����µı�
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

	//����в�������
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
	
	//����������Ϣ
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
	
	/*����������Ϣ
	 cityname��������
	 day����ѯ��ʱ�䣨1Ϊ���죬2Ϊ���죬�Դ����ƣ�
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
					System.out.println("����:"+rs.getString("date"));
					System.out.println("����:"+rs.getString("week"));
					System.out.println("��������:"+rs.getString("dayweather"));
					System.out.println("ҹ������:"+rs.getString("nightweather"));
					System.out.println("�����¶�:"+rs.getString("daytemp"));
					System.out.println("ҹ���¶�:"+rs.getString("nighttemp"));
					System.out.println("�������:"+rs.getString("daywind"));
					System.out.println("ҹ�����:"+rs.getString("nightwind"));
					System.out.println("�������:"+rs.getString("daypower"));
					System.out.println("ҹ�����:"+rs.getString("nightpower"));
				}
			}else {
				System.out.print("�����������������ճ������Ʊ�");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,st,rs,stmt);
		}
	}
	
	//�ر���Դ
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
