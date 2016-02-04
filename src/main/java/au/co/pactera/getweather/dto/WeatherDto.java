package au.co.pactera.getweather.dto;

import java.io.Serializable;

public class WeatherDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String city;

	private String updTime;
	
	private String weather;
	
	private String temperature;
	
	private String wind;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the updTime
	 */
	public String getUpdTime() {
		return updTime;
	}

	/**
	 * @param updTime the updTime to set
	 */
	public void setUpdTime(String updTime) {
		this.updTime = updTime;
	}

	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the wind
	 */
	public String getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}

}