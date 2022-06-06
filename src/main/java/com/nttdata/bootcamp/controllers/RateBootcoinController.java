package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.RateBootcoinResponse;
import com.nttdata.bootcamp.services.IRateBootcoinService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/rateBootcoin")
public class RateBootcoinController {
	
	@Autowired
	private IRateBootcoinService repo;
	
	@GetMapping(value="/active", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<RateBootcoinResponse> getAll(){
		return repo.getAllActiveRateBootcoinList();
	}

}
