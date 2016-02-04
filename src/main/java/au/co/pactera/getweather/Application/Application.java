package au.co.pactera.getweather.Application;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import au.co.pactera.getweather.properties.annotation.PropertyInfo;
import au.co.pactera.getweather.service.WeatherService;
import au.co.pactera.getweather.service.impl.WeatherServiceImpl;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
    	DispatcherServlet servlet = new DispatcherServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsp");
        servletRegistrationBean.setName("mvc-dispatcher");
		return servletRegistrationBean;
    }
    
    @Bean
    public PropertyInfo propertyInfo(){
    	return new PropertyInfo();
    }
    
    @Bean 
    public WeatherService weatherService(){
    	return new WeatherServiceImpl();
    }
}
