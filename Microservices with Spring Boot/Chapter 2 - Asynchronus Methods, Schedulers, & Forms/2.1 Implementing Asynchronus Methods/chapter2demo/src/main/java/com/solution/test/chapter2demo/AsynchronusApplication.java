package com.solution.test.chapter2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsynchronusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronusApplication.class, args).close(); //The close() helps to close the application as soon as it has run.
	}
	
	@Bean
	public Executor taskExecutor() {
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("LookupId - ");
		executor.initialize();
		
		return executor;
	}

}
