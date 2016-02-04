package au.co.pactera.getweather.service;

import au.co.pactera.getweather.dto.WeatherDto;

public interface WeatherService {

	public WeatherDto getWeatherInfoByCd(String cityCd, String cityNm) throws Exception;
}
