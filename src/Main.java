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
		
		//���ļ��д���ĳ��������Լ���Ӧ�ĳ��б�Ŵ���city�����У���ִ��city�Ĺ��캯��ͨ�����ݽӿڻ�ȡ������Ϣ
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
		
		//�������ݿ�WeatherForecast
		mysql.CreateDatabase("WeatherForecast");
		

		/*��WeatherForecast�д�����һ�ű�city���ڴ洢����������б�ŵĶ�Ӧ
		CityName����������
		CityNum�����б��
		*/
		mysql.CreateTable("WeatherForecast","CREATE TABLE city(CityName varchar(30) not null,CityNum int not null)CHARACTER SET utf8mb4");

		/*��WeatherForecast�д����ڶ��ű�weather���ڴ洢��������Ԥ��������Ϣ
		 id������Ԥ����Ϣ��ţ�ǰ��λΪ���б�ţ���һλΪ�ڼ����������Ϣ����110101����������Ͻ�����������Ԥ��
		 date������Ԥ����Ӧ������
		 week������Ԥ����Ӧ������
		 dayweather����������
		 nightweather��ҹ������
		 daytemp�������¶�
		 nighttemp��ҹ���¶�
		 daywind���������
		 nightwind��ҹ�����
		 daypower���������
		 nightpower��ҹ����� 
		 */
		mysql.CreateTable("WeatherForecast","CREATE TABLE weather(id int,date varchar(15),week varchar(10),dayweather varchar(10),nightweather varchar(10),daytemp varchar(10),nighttemp varchar(10),daywind varchar(15),nightwind varchar(15),daypower varchar(10),nightpower varchar(10))CHARACTER SET utf8mb4");
		
		//��mysql���ݿ��в�������
		mysql.Insert("WeatherForecast", city);
		
		
		//ʵ�����ݿ����
		for (int i=0;i<city.size();i++) {
			city.get(i).Update();
		}
		mysql.Update("WeatherForecast", city);
		
		//����������Ϣ
		System.out.print("�������ѯ�ĳ�����");
		Scanner in=new Scanner(System.in);
		String cityname=in.nextLine();
		System.out.print("������Ҫ��ѯ��ʱ�䣨1Ϊ���죬2Ϊ���죬�Դ����ƣ�");
		int day=in.nextInt();
		mysql.Search("WeatherForecast", cityname, day);
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		

