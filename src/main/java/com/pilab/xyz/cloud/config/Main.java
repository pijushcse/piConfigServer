package com.pilab.xyz.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
@ComponentScan("com.pilab.xyz.cloud.config")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
