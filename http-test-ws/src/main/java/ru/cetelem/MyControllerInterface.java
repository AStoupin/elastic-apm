package ru.cetelem;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Path("/")
public interface MyControllerInterface {
	
	@Path("hellow")
	@GET
	public String helloWorld(@QueryParam("name") String name);

}


