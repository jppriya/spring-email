package com.jp.poc.email.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

	private VelocityEngine velocityEngine;

	@Bean
	public VelocityEngine velocityEngine() throws VelocityException, IOException {
		if (null == velocityEngine) {
			Properties props = new Properties();
			props.setProperty("resource.loader", "class");
			props.setProperty("class.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			velocityEngine = new VelocityEngine(props);
		}
		return velocityEngine;
	}
}
