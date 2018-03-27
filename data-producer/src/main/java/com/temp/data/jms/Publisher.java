package com.temp.data.jms;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	final static Logger LOGGER = Logger.getLogger(Publisher.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${myapp.activemq.topic}")
	String topic;
	
	public void sendMessage(Object msg) throws JMSException {
		LOGGER.debug("Publishing message " + msg);
		jmsTemplate.convertAndSend(topic, msg);
	}
}
