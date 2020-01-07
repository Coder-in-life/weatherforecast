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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class City {
	public int citynum;
	public String cityname;
	public Forecast[]forecast=new Forecast[4];
	public City(int num,String name) {
		citynum=num;
		cityname=name;
		
		String url="https://restapi.amap.com/v3/weather/weatherInfo?city="+String.valueOf(citynum)+"&key=9fef525253bbb24deea5f59151609c19&extensions=all";
		StringBuffer strbuf=new StringBuffer();
		try {
			URL Url=new URL(url);
			URLConnection conn=Url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line=null;
			while ((line=reader.readLine())!=null) 
				strbuf.append(line+" ");
			reader.close();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		String str=strbuf.toString();
		JSONObject json=new JSONObject(str);
		
		JSONArray array1=json.getJSONArray("forecasts");
		JSONObject forecasts=array1.getJSONObject(0);
		JSONArray array=forecasts.getJSONArray("casts");
		for (int i=0;i<4;i=i+1) {
			JSONObject weather=array.getJSONObject(i);
			forecast[i]=new Forecast();
			forecast[i].date=String.valueOf(weather.getString("date"));
			forecast[i].daypower=weather.getString("daypower");
			forecast[i].week=weather.getString("week");
			forecast[i].dayweather=weather.getString("dayweather");
			forecast[i].nightweather=weather.getString("nightweather");
			forecast[i].daytemp=weather.getString("daytemp");
			forecast[i].nighttemp=weather.getString("nighttemp");
			forecast[i].daywind=weather.getString("daywind");
			forecast[i].nightwind=weather.getString("nightwind");
			forecast[i].nightpower=weather.getString("nightpower");
		}

	}
	
	//City类中的更新函数，重新对数据接口进行请求，将天气数据重新录入数据库内。
	public void Update() {
		String url="https://restapi.amap.com/v3/weather/weatherInfo?city="+String.valueOf(citynum)+"&key=9fef525253bbb24deea5f59151609c19&extensions=all";
		StringBuffer strbuf=new StringBuffer();
		try {
			URL Url=new URL(url);
			URLConnection conn=Url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line=null;
			while ((line=reader.readLine())!=null) 
				strbuf.append(line+" ");
			reader.close();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		String str=strbuf.toString();
		JSONObject json=new JSONObject(str);
		
		JSONArray array1=json.getJSONArray("forecasts");
		JSONObject forecasts=array1.getJSONObject(0);
		JSONArray array=forecasts.getJSONArray("casts");
		for (int i=0;i<4;i=i+1) {
			JSONObject weather=array.getJSONObject(i);
			forecast[i].date=String.valueOf(weather.getString("date"));
			forecast[i].daypower=weather.getString("daypower");
			forecast[i].week=weather.getString("week");
			forecast[i].dayweather=weather.getString("dayweather");
			forecast[i].nightweather=weather.getString("nightweather");
			forecast[i].daytemp=weather.getString("daytemp");
			forecast[i].nighttemp=weather.getString("nighttemp");
			forecast[i].daywind=weather.getString("daywind");
			forecast[i].nightwind=weather.getString("nightwind");
			forecast[i].nightpower=weather.getString("nightpower");
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
