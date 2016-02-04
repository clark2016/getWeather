package au.co.pactera.getweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.co.pactera.getweather.controller.WeatherController;
import au.co.pactera.getweather.dto.WeatherDto;
import au.co.pactera.getweather.properties.annotation.PropertyInfo;
import au.co.pactera.getweather.service.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringApplicationConfiguration(classes = WeatherController.class)
public class WeatherServiceTest {

	@Autowired
	WeatherService weatherService;
	
	@Autowired
	PropertyInfo propertyInfo;

	@Test
	public void getRightData() throws JSONException, IOException, Exception {
		WeatherDto wto= weatherService.getWeatherInfoByCd("7839805", "Melbourne");
	    assertNotNull(wto);
		assertEquals("Expected city name","Melbourne",wto.getCity());
		assertNotNull(wto.getTemperature());
		assertNotNull(wto.getUpdTime());
		assertNotNull(wto.getWind());
		assertNotNull(wto.getCity());
	}
	
	@Test(expected=JSONException.class)
	public void failueTestUnknownCityName() throws IOException, Exception {
		weatherService.getWeatherInfoByCd("a1111234", "Melbourne");
	 }
	
	@Test(expected=RuntimeException.class)
	public void failueTestServerNotRechable() throws IOException, Exception {
		propertyInfo.setOpenUrl("aadsfasfsdf");
		weatherService.getWeatherInfoByCd("a1111234", "Melbourne");
	 }
	
/*	@Test(expected=MalformedURLException.class)
	public void failueTestUnknownURL() throws IOException, Exception {
		weatherService.getWeather("Melbourne,Aus", propertyInfo.getAppID(), "");
	 }
	
	@Test(expected=UnknownHostException.class)
	public void failueTestServerNotRechable() throws IOException, Exception {
		    weatherService.getWeather("Melbourne,Aus", propertyInfo.getAppID(), propertyInfo.getAppURL());
	 }
	
	@Test(expected=RuntimeException.class)
	public void failureTestBlankAppID() throws JSONException, IOException, Exception {
			weatherService.getWeather("Melbourne,Aus", "", propertyInfo.getAppURL());
		}*/

}
