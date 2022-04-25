package com.solution.test.chapter2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsynchronusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronusApplication.class, args); //The close() helps to close the application as soon as it has run.
	}
	
	@Bean
	public Executor taskExecutor() {
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(1);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("LookupId - ");
		executor.initialize();
		
		return executor;
	}

}
