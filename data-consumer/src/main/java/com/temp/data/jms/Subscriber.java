package com.temp.data.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.temp.data.dataobject.TickData;
import com.temp.data.repository.TickDataRepository;


@Component
public class Subscriber {
	
	@Autowired
	private TickDataRepository repository;
	
	@JmsListener(destination = "${myapp.activemq.topic}")
	public void receive(TickData data){
		System.out.println("Recieved Message: " + data);
		repository.save(data);
	}
}
