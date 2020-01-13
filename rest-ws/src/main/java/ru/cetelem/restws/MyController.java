package ru.cetelem.restws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.cxf.tracing.opentracing.OpenTracingClientFeature;

import co.elastic.apm.opentracing.ElasticApmTracer;
import io.opentracing.Tracer;

import ru.cetelem.TestService1;

@RestController
public class MyController {
	private static final Log LOG = LogFactory.getLog(TestService1.class); 


	@GetMapping("hellos")
	public String helloAndStop(String name) {
		
		LOG.info("Hellos, " + name);
		return "Hellos, " + name;
	}
	
	@GetMapping("hellow")
	public String helloWorld(String name) {
		executeHttpClient();
		executeCxfJaxWs();

		

		
		
		return "Hellow, " + name;
	}

	private void executeHttpClient() {
		LOG.info("executeHttpClient");
		//HttpAsyncClient a;
		final CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		 HttpGet request = new HttpGet("http://www.ya.ru");
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
		
	}

	private void executeCxfJaxWs() {
		LOG.info("executeCxfJaxWs started");

		Tracer tracer = new ElasticApmTracer();
		JaxWsProxyFactoryBean serverFactory = new JaxWsProxyFactoryBean();
		/*OpenTracingClientFeature otp = new OpenTracingClientFeature(tracer);
		serverFactory.setFeatures(Arrays.asList(otp));
*/
		// serverFactory.getBus().setExtension(destinationFactory,
		// HttpDestinationFactory.class);
		serverFactory.setAddress("http://localhost:8081/services/http-test-ws");

		serverFactory.setServiceClass(TestService1.class);

		//

		TestService1 svc = (TestService1) serverFactory.create();
		LOG.info("ws Start");

		String s = svc.helloWorld1("9999");
		LOG.info("ws Finish");
		
	}
}
