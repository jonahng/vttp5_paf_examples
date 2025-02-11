package com.jonah.vttp5_paf_day05ws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

import com.jonah.vttp5_paf_day05ws.bootstraps.MessageProcessor;

@SpringBootApplication
@EnableAsync
public class Day29application implements CommandLineRunner {

	@Autowired
	private MessageProcessor msgProcessor;

	@Autowired @Qualifier("myredis")
	RedisTemplate<String, String> redisTemplate;


	@Override
	public void run(String... args) {
		System.out.printf("Start up\n");
		msgProcessor.startPoller();

		redisTemplate.convertAndSend(
			"notifications", "Application started on %s".formatted(new Date().toString()));

	}

}