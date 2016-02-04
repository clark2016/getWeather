package au.co.pactera.getweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.co.pactera.getweather.dto.WeatherDto;
import au.co.pactera.getweather.properties.annotation.PropertyInfo;
import au.co.pactera.getweather.service.WeatherService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
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

	// close the network and test
/*	@Test(expected=MalformedURLException.class)
	public void failueTestServerNotRechable() throws IOException, Exception {
		String url = propertyInfo.getOpenUrl();
		//propertyInfo.setOpenUrl("aadsfasfsdf");
		weatherService.getWeatherInfoByCd("7839805", "Melbourne");
		//propertyInfo.setOpenUrl(url);
	 }*/
	
	@Test(expected=JSONException.class)
	public void failueTestUnknownCityName() throws IOException, Exception {
		weatherService.getWeatherInfoByCd("a1111234", "Melbourne");
	 }


}
