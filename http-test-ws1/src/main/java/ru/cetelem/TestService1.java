package ru.cetelem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;

@WebService
public class TestService1 {
	private static final Log LOG = LogFactory.getLog(TestService1.class); 
	
	@WebMethod
	public String helloWorld1(String name) {
		LOG.info("TestService1 started "+ name);
		executeHttpClient();
		LOG.info("TestService1 finished");
		return "Hello, " + name ;
	}

	private void executeHttpClient() {
		//HttpAsyncClient a;
		LOG.info("executeHttpClient started");
		final CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		 HttpGet request = new HttpGet("http://www.google.ru");
		 try {
			HttpResponse response = httpClient.execute(request);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
	
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}			
				 httpClient.close();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
			LOG.info("executeHttpClient finished");

	}
}
