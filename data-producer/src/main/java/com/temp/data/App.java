package com.temp.data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import com.temp.data.generator.Producer;
import com.temp.data.jms.Publisher;

@SpringBootApplication
@EnableJms
public class App implements CommandLineRunner {

	@Autowired
	private Publisher publisher;

	private Producer producer;

	private ExecutorService executor;

	@Override
	public void run(String... args) {
		producer = new Producer();

		producer.setPublisher(publisher);

		executor = Executors.newFixedThreadPool(2);
		executor.submit(producer);

	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		// System.out.println("PUBLISHER " + ctx.getBean(Publisher.class));
		// App app = new App();

	}

}
