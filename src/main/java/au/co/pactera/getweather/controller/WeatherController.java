package au.co.pactera.getweather.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.co.pactera.getweather.dto.WeatherDto;
import au.co.pactera.getweather.properties.annotation.PropertyInfo;
import au.co.pactera.getweather.service.WeatherService;

@SessionScoped
@Controller
@RequestMapping("/")
public class WeatherController {

	private Map<String, String> cityList;

	private static Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	WeatherService weatherService;

	@Autowired
	private PropertyInfo propertyInfo;

	/**
	 * This function initialize controller to get city list from properties file
	 * 
	 * @return String
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getWeather(ModelMap model) {

		// function start,output log
		logger.info(String.format(propertyInfo.getInfomsg1(), "getWeather"));

		String defaultCityNm = propertyInfo.getDefaultCity();

		String defaultCityCd = cityList.get(defaultCityNm).toString();

		WeatherDto weather = new WeatherDto();

		try {
			weather = weatherService.getWeatherInfoByCd(defaultCityCd, defaultCityNm);

		} catch (Exception e) {

			logger.error(String.format(propertyInfo.getErrormsg1(), "getWeather", e.getMessage()));

			model.addAttribute("errormsg", propertyInfo.getErrormsg2());
		}

		setValueToModel(weather, model);

		// function end,output log
		logger.info(String.format(propertyInfo.getInfomsg2(), "getWeather"));
		return "weather";
	}

	/**
	 * This function initialize controller to get city list from properties file
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/{currentCity}", method = RequestMethod.GET)
	public String getWeather(@PathVariable String currentCity, ModelMap model) {

		logger.info(String.format(propertyInfo.getInfomsg1(), "changeCity"));

		String currentCityCd = cityList.get(currentCity).toString();

		WeatherDto weather = new WeatherDto();

		try {
			weather = weatherService.getWeatherInfoByCd(currentCityCd, currentCity);

		} catch (Exception e) {

			logger.error(String.format(propertyInfo.getErrormsg1(), "changeCity", e.getMessage()));

			model.addAttribute("errormsg", propertyInfo.getErrormsg2());
		}

		setValueToModel(weather, model);

		logger.info(String.format(propertyInfo.getInfomsg2(), "changeCity"));

		return "weather";

	}

	/**
	 * This function initialize controller to get city list from properties file
	 * 
	 * @return
	 */
	@PostConstruct
	void init() {

		logger.info(String.format(propertyInfo.getInfomsg1(), "init"));

		createCityList();

		// String defaultCityName = propertyInfo.getDefaultCity();

		logger.info(String.format(propertyInfo.getInfomsg2(), "init"));

	}

	/**
	 * This method rip out the weather data to populate the ModelMap
	 * 
	 * @param weather
	 *            - WeatherDto
	 * @param model
	 *            - ModelMap
	 * @return
	 */
	private void setValueToModel(WeatherDto weather, ModelMap model) {

		model.addAttribute("citylist", cityList);

		model.addAttribute("welcomemsg", "");

		model.addAttribute("cityName", weather.getCity());

		model.addAttribute("updatedTime", weather.getUpdTime());

		model.addAttribute("weather", weather.getWeather());

		model.addAttribute("temperature", weather.getTemperature());

		model.addAttribute("wind", weather.getWind());

	}

	/**
	 * This method split the properties data to city map
	 * 
	 * @return
	 */
	private void createCityList() {
		String[] tmpcityNameList = propertyInfo.getCitieNameList().split(";");
		String[] tmpcityCdList = propertyInfo.getCityIdList().split(";");
		cityList = new HashMap<String, String>();
		for (int i = 0; i < tmpcityCdList.length; i++) {
			cityList.put(tmpcityNameList[i], tmpcityCdList[i]);
		}
	}
}
