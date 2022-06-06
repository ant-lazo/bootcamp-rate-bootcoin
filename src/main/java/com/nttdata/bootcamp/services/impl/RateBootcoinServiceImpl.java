package com.nttdata.bootcamp.services.impl;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.RateBootcoin;
import com.nttdata.bootcamp.models.RateBootcoinResponse;
import com.nttdata.bootcamp.repository.IRateBootcoinRepo;
import com.nttdata.bootcamp.services.IRateBootcoinService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RateBootcoinServiceImpl implements IRateBootcoinService{
	
	
	private final IRateBootcoinRepo repoRate;

	@Override
	public Mono<String> createRateBootcoin(RateBootcoin rateBootcoin) {
		return repoRate.save(rateBootcoin).map(r->r.getId());
	}

	@Override
	public Flux<RateBootcoinResponse> getAllActiveRateBootcoinList() {
		return repoRate.findAll()
				.filter(RateBootcoin::isActive)
				.map(rate->RateBootcoinResponse.builder()
						.id(rate.getId())
						.typeTransaction(rate.getTypeTransaction())
						.minimunAmount(rate.getMinimunAmount())
						.maximunAmount(rate.getMaximunAmount())
						.price(rate.getPrice())
						.build());
	}

	@Override
	public Mono<Long> count() {
		return repoRate.count();
	}

}
