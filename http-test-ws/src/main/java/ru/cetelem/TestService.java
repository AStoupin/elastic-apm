package ru.cetelem;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebService
public class TestService {
	private static final Log LOG = LogFactory.getLog(TestService.class); 
	
	@WebMethod
	public String helloWorld(String name) {

/*		JAXRSClientFactoryBean clientFactory = new JAXRSClientFactoryBean();
		clientFactory.setAddress("http://localhost:8888/");
		clientFactory.setServiceClass(MyControllerInterface.class);
		//clientFactory.getFeatures().add(new BraveClientFeature(tracing));
		MyControllerInterface myController = (MyControllerInterface)clientFactory.create();
		
		String res = myController.helloWorld("00000");
	*/
		LOG.info("helloWorld Started " + name);
		
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.getForObject("http://localhost:8888/hellow", String.class);
		
		LOG.info("helloWorld finished  " + name);

		return "Hello, " + name + ", " + res;
	}
}
