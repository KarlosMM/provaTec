package com.npaw.responseservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResponseServiceApplication {

	private static final Logger LOGGER =  LogManager.getLogger();
	public static void main(String[] args) {
		try {
	        SpringApplication.run(ResponseServiceApplication.class, args);
	    } catch (Throwable e) {
	        if(e.getClass().getName().contains("SilentExitException")) {
	            LOGGER.debug("Spring is restarting the main thread - See spring-boot-devtools");
	        } else {
	            LOGGER.error("Application crashed!", e);
	        }
	    }
	}

}
