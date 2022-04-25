package com.solution.test.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 3000, initialDelay = 5000)
	public void scheduledLookup() throws InterruptedException {
		System.out.println("The time is now: "+dateFormat.format(new Date()));
		
		Thread.sleep(5000);
	}
}
