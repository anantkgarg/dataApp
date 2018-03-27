package com.temp.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.temp.data.dataobject.TickData;

public interface TickDataRepository extends MongoRepository<TickData, Integer> {
	public Page<TickData> findAllByOrderByDateDesc(Pageable pageable);
}
