package com.lexue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
/**
 * eureka服务端
 */
@EnableEurekaServer
@EnableWebSecurity
public class EurekaServerApplication extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//关闭csrf校验
		http.csrf().disable();
		//开启认证，URL格式登陆必须是HttpBasic
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
