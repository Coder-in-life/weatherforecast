import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.sql.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//将文件中储存的城市名称以及对应的城市编号存入city数组中，并执行city的构造函数通过数据接口获取天气信息
		ArrayList<City> city=new ArrayList<City>();
		ArrayList<String> name=new ArrayList<String>();
		File file=new File("cityname.txt");
		File file2=new File("citynum.txt");
		BufferedReader reader=null;
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
			InputStreamReader read2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
			reader=new BufferedReader(read);
			String temp=null;
			int line=1;
			while((temp=reader.readLine())!=null) {
				name.add(temp);
				line++;
			}
			reader.close();
			reader=new BufferedReader(read2);
			temp=null;
		    line=1;
			while((temp=reader.readLine())!=null) {
				int num=Integer.valueOf(temp);
				String cityname=name.get(line-1);
				City index=new City(num,cityname);
				city.add(index);
				line++;
			}
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (reader!=null) {
				try {
					reader.close();
				}catch(IOException e1) {}
			}
		}
		
		MySQL mysql=new MySQL();
		
		//创建数据库WeatherForecast
		mysql.CreateDatabase("WeatherForecast");
		

		/*在WeatherForecast中创建第一张表city用于存储城市名与城市编号的对应
		CityName：城市名称
		CityNum：城市编号
		*/
		mysql.CreateTable("WeatherForecast","CREATE TABLE city(CityName varchar(30) not null,CityNum int not null)CHARACTER SET utf8mb4");

		/*在WeatherForecast中创建第二张表weather用于存储城市天气预报具体信息
		 id：天气预报信息编号，前六位为城市编号，后一位为第几天的天气信息，如110101即北京市市辖区今天的天气预报
		 date：天气预报对应的日期
		 week：天气预报对应的星期
		 dayweather：白天天气
		 nightweather：夜晚天气
		 daytemp：白天温度
		 nighttemp：夜晚温度
		 daywind：白天风向
		 nightwind：夜晚风向
		 daypower：白天风力
		 nightpower：夜晚风力 
		 */
		mysql.CreateTable("WeatherForecast","CREATE TABLE weather(id int,date varchar(15),week varchar(10),dayweather varchar(10),nightweather varchar(10),daytemp varchar(10),nighttemp varchar(10),daywind varchar(15),nightwind varchar(15),daypower varchar(10),nightpower varchar(10))CHARACTER SET utf8mb4");
		
		//向mysql数据库中插入数据
		mysql.Insert("WeatherForecast", city);
		
		
		//实现数据库更新
		for (int i=0;i<city.size();i++) {
			city.get(i).Update();
		}
		mysql.Update("WeatherForecast", city);
		
		//查找天气信息
		System.out.print("请输入查询的城市名");
		Scanner in=new Scanner(System.in);
		String cityname=in.nextLine();
		System.out.print("请输入要查询的时间（1为今天，2为明天，以此类推）");
		int day=in.nextInt();
		mysql.Search("WeatherForecast", cityname, day);
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		

