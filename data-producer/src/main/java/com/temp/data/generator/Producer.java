package com.temp.data.generator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.temp.data.dataobject.TickData;
import com.temp.data.jms.Publisher;

public class Producer implements Callable<Integer> {

	private int count = 0;
	
	final static Logger LOGGER = Logger.getLogger(Producer.class);
	
	private static Random random = new Random();
	
//	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD HHmmss.SSS");
//	private NumberFormat numberFormat = new DecimalFormat("#0.0000");
	
	private Publisher publisher;
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public Integer call() throws Exception {
		LOGGER.debug("Producer Started.....");
		do {
			double randomPx = randomPx();
			
			TickData data = new TickData(new Date(), BigDecimal.valueOf(randomPx));

			LOGGER.debug("Sending message " + data);
			publisher.sendMessage(data);
			
			count++;
			Thread.sleep(1500L);
		} while(count <=1_000_000_000);
		return count;
	}

	private double randomPx() {
		double leftLimit = 50F;
	    double rightLimit = 55F;
	    double generated = leftLimit + random.nextDouble() * (rightLimit - leftLimit);
		return generated;
	}

}
