package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.RateBootcoin;
import com.nttdata.bootcamp.models.RateBootcoinResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRateBootcoinService {
	Mono<String> createRateBootcoin(RateBootcoin rateBootcoin);
	Flux<RateBootcoinResponse> getAllActiveRateBootcoinList();
	Mono<Long> count();
}
