package com.perpro.rest.services.main;

import com.perpro.rest.common.constants.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { CommonConstants.BASE_PACKAGE })
@EntityScan(basePackages = {CommonConstants.BASE_PACKAGE})
@EnableJpaRepositories(basePackages = CommonConstants.BASE_PACKAGE)

public class CalorieApp {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(CalorieApp.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}
}
