package au.co.pactera.getweather.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.co.pactera.getweather.dto.WeatherDto;
import au.co.pactera.getweather.properties.annotation.PropertyInfo;
import au.co.pactera.getweather.service.WeatherService;
import au.co.pactera.getweather.util.Common;

/**
 * Service layer for GetWeather-war application.
 * This class contains methods that call external API to get the weather information.
 */

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private PropertyInfo propertyInfo;

	public WeatherServiceImpl() {

	}

	/**
	 * This method calls the appropriate API to fetch weather information
	 * 
	 * @param cityCd
	 *            - code of city for which weather information is to be retrieved
	 * @param cityNm
	 *            - cityNm
	 * @return WeatherDto
	 * @throws Exception
	 */
	public WeatherDto getWeatherInfoByCd(String cityCd, String cityNm) throws Exception {

		String appID = propertyInfo.getAppId();

		String openURL = propertyInfo.getOpenUrl();

		JSONObject jsn = Common.parseJson(getWeatherFromOpenWeather(cityCd, appID, openURL));

		WeatherDto weather = new WeatherDto();

		weather.setCity(cityNm);

		weather.setTemperature(Common.absToCel(jsn.getJSONObject("main").getString("temp")));

		Date tmpDt = new Date();
		
		String dateHMA = Common.formatDateHMA(tmpDt);
		
		String dateYYYYMMDD = Common.formatDateYYYYMMDD(tmpDt);
		
		weather.setUpdTime(Common.getWeekStr(dateYYYYMMDD) + " " + dateHMA);

		weather.setWeather(((JSONObject)jsn.getJSONArray("weather").get(0)).getString("description"));

		weather.setWind(jsn.getJSONObject("wind").getString("speed") + "km/hr");

		return weather;
	}

	/**
	 * This method calls the appropriate API to fetch weather information
	 * 
	 * @param cityCd
	 *            - code of city for which weather information is to be retrieved
	 * @param appID
	 *            - unique appID required to call the API
	 * @param openURL
	 *            - API URL to call
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	private String getWeatherFromOpenWeather(String cityCd, String appID, String openURL)
			throws IOException, Exception {
		String jsonString = null;
		URL url = new URL(String.format(openURL, cityCd, appID));
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET");
		huc.setRequestProperty("Accept", "application/json");
		if (huc.getResponseCode() != 200) {
			huc.disconnect();
			throw new RuntimeException("Failed : HTTP error code : " + huc.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((huc.getInputStream())));
		jsonString = br.readLine();
		br.close();
		huc.disconnect();
		return jsonString;
	}
}
