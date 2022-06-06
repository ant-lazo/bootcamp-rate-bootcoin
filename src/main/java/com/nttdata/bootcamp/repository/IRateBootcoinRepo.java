package com.nttdata.bootcamp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.RateBootcoin;

public interface IRateBootcoinRepo extends ReactiveMongoRepository<RateBootcoin, String>{

}
