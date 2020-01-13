package ru.cetelem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.apache.cxf.jaxws.EndpointImpl; 
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;

@SpringBootApplication
@Configuration
//@ImportResource("applicationContext.xml")
public class HttpTestWsApplication {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public TestService TestService() {
		return new TestService();
	}
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, TestService());
		endpoint.publish("/http-test-ws");
		
		return endpoint;
	} 	
	
	public static void main(String[] args) {
		SpringApplication.run(HttpTestWsApplication.class, args);
	}
}
