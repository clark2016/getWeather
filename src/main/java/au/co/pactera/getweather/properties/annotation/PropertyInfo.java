package au.co.pactera.getweather.properties.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class PropertyInfo {

	@Value("${city.name.defaultcity}")
	private String defaultCity;

	@Value("${city.name.list}")
	private String citieNameList;

	@Value("${city.id.list}")
	private String cityIdList;

	@Value("${openweathermap.url}")
	private String openUrl;

	@Value("${openweathermap.appid}")
	private String appId;

	@Value("${infomsg1}")
	private String infomsg1;

	@Value("${infomsg2}")
	private String infomsg2;

	@Value("${infomsg3}")
	private String infomsg3;

	@Value("${infomsg4}")
	private String infomsg4;

	@Value("${infomsg5}")
	private String infomsg5;

	@Value("${errormsg1}")
	private String errormsg1;

	/**
	 * @return the defaultCity
	 */
	public String getDefaultCity() {
		return defaultCity;
	}

	/**
	 * @param defaultCity the defaultCity to set
	 */
	public void setDefaultCity(String defaultCity) {
		this.defaultCity = defaultCity;
	}

	/**
	 * @return the citieNameList
	 */
	public String getCitieNameList() {
		return citieNameList;
	}

	/**
	 * @param citieNameList the citieNameList to set
	 */
	public void setCitieNameList(String citieNameList) {
		this.citieNameList = citieNameList;
	}

	/**
	 * @return the cityIdList
	 */
	public String getCityIdList() {
		return cityIdList;
	}

	/**
	 * @param cityIdList the cityIdList to set
	 */
	public void setCityIdList(String cityIdList) {
		this.cityIdList = cityIdList;
	}

	/**
	 * @return the openUrl
	 */
	public String getOpenUrl() {
		return openUrl;
	}

	/**
	 * @param openUrl the openUrl to set
	 */
	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the infomsg1
	 */
	public String getInfomsg1() {
		return infomsg1;
	}

	/**
	 * @param infomsg1 the infomsg1 to set
	 */
	public void setInfomsg1(String infomsg1) {
		this.infomsg1 = infomsg1;
	}

	/**
	 * @return the infomsg2
	 */
	public String getInfomsg2() {
		return infomsg2;
	}

	/**
	 * @param infomsg2 the infomsg2 to set
	 */
	public void setInfomsg2(String infomsg2) {
		this.infomsg2 = infomsg2;
	}

	/**
	 * @return the infomsg3
	 */
	public String getInfomsg3() {
		return infomsg3;
	}

	/**
	 * @param infomsg3 the infomsg3 to set
	 */
	public void setInfomsg3(String infomsg3) {
		this.infomsg3 = infomsg3;
	}

	/**
	 * @return the infomsg4
	 */
	public String getInfomsg4() {
		return infomsg4;
	}

	/**
	 * @param infomsg4 the infomsg4 to set
	 */
	public void setInfomsg4(String infomsg4) {
		this.infomsg4 = infomsg4;
	}

	/**
	 * @return the infomsg5
	 */
	public String getInfomsg5() {
		return infomsg5;
	}

	/**
	 * @param infomsg5 the infomsg5 to set
	 */
	public void setInfomsg5(String infomsg5) {
		this.infomsg5 = infomsg5;
	}

	/**
	 * @return the errormsg1
	 */
	public String getErrormsg1() {
		return errormsg1;
	}

	/**
	 * @param errormsg1 the errormsg1 to set
	 */
	public void setErrormsg1(String errormsg1) {
		this.errormsg1 = errormsg1;
	}

	/**
	 * @return the errormsg2
	 */
	public String getErrormsg2() {
		return errormsg2;
	}

	/**
	 * @param errormsg2 the errormsg2 to set
	 */
	public void setErrormsg2(String errormsg2) {
		this.errormsg2 = errormsg2;
	}

	/**
	 * @return the errormsg3
	 */
	public String getErrormsg3() {
		return errormsg3;
	}

	/**
	 * @param errormsg3 the errormsg3 to set
	 */
	public void setErrormsg3(String errormsg3) {
		this.errormsg3 = errormsg3;
	}

	/**
	 * @return the errormsg4
	 */
	public String getErrormsg4() {
		return errormsg4;
	}

	/**
	 * @param errormsg4 the errormsg4 to set
	 */
	public void setErrormsg4(String errormsg4) {
		this.errormsg4 = errormsg4;
	}

	/**
	 * @return the errormsg5
	 */
	public String getErrormsg5() {
		return errormsg5;
	}

	/**
	 * @param errormsg5 the errormsg5 to set
	 */
	public void setErrormsg5(String errormsg5) {
		this.errormsg5 = errormsg5;
	}

	@Value("${errormsg2}")
	private String errormsg2;

	@Value("${errormsg3}")
	private String errormsg3;

	@Value("${errormsg4}")
	private String errormsg4;

	@Value("${errormsg5}")
	private String errormsg5;
}