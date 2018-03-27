package com.temp.data.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temp.data.dataobject.TickData;
import com.temp.data.repository.TickDataRepository;

@RestController
public class DataController {

	private final static Logger LOGGER = Logger.getLogger(DataController.class);
	@Autowired
	private TickDataRepository repository;

	@RequestMapping("/data/avg/{lastCount}")
	public double getAvgOf(@PathVariable("lastCount") Integer count) {
		LOGGER.debug(String.format("Received requests for average of last %s entries", count));
		List<TickData> data =  null;
		PageRequest request = new PageRequest(0, count, new Sort(Sort.Direction.DESC, "date"));
		data = repository.findAllByOrderByDateDesc(request).getContent();
		
		LOGGER.debug(data);
		DoubleSummaryStatistics statistics = data.stream().limit(count).collect(Collectors.summarizingDouble(TickData::getPxDouble));
		return statistics.getAverage();
	}

	@RequestMapping("/data/{lastCount}")
	public List<TickData> getData(@PathVariable("lastCount") Integer count) {
		LOGGER.debug(String.format("Received requests for average of last %s entries", count));
		List<TickData> data =  null;
		PageRequest request = new PageRequest(0, count, new Sort(Sort.Direction.DESC, "date"));
		data = repository.findAllByOrderByDateDesc(request).getContent();
		
		LOGGER.debug(data);
		return data;
	}
}
