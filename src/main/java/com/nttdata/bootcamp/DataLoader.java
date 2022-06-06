package com.nttdata.bootcamp;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.models.RateBootcoin;
import com.nttdata.bootcamp.services.IRateBootcoinService;
import com.nttdata.bootcamp.utils.Constants;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private IRateBootcoinService rateService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(rateService.count().block().equals(0L)) {
			RateBootcoin rateBootCoin1 = RateBootcoin.builder()
					.id(UUID.randomUUID().toString())
					.description("Purchase Rate 1")
					.typeTransaction(Constants.PURCHASERATE)
					.minimunAmount(BigDecimal.valueOf(0))
					.maximunAmount(BigDecimal.valueOf(100))
					.price(BigDecimal.valueOf(3))
					.status("1")
					.build();
			
			RateBootcoin rateBootCoin2 = RateBootcoin.builder()
					.id(UUID.randomUUID().toString())
					.description("Purchase Rate 2")
					.typeTransaction(Constants.PURCHASERATE)
					.minimunAmount(BigDecimal.valueOf(101))
					.maximunAmount(BigDecimal.valueOf(1000000))
					.price(BigDecimal.valueOf(2.8))
					.status("1")
					.build();
			
			RateBootcoin rateBootCoin3 = RateBootcoin.builder()
					.id(UUID.randomUUID().toString())
					.description("Selling Rate 1")
					.typeTransaction(Constants.SELLINGRATE)
					.minimunAmount(BigDecimal.valueOf(0))
					.maximunAmount(BigDecimal.valueOf(100))
					.price(BigDecimal.valueOf(2.7))
					.status("1")
					.build();
			
			RateBootcoin rateBootCoin4 = RateBootcoin.builder()
					.id(UUID.randomUUID().toString())
					.description("Selling Rate 2")
					.typeTransaction(Constants.SELLINGRATE)
					.minimunAmount(BigDecimal.valueOf(101))
					.maximunAmount(BigDecimal.valueOf(1000000))
					.price(BigDecimal.valueOf(2.5))
					.status("1")
					.build();
			
			RateBootcoin rateBootCoin5 = RateBootcoin.builder()
					.id(UUID.randomUUID().toString())
					.description("Selling Rate 2")
					.typeTransaction(Constants.SELLINGRATE)
					.minimunAmount(BigDecimal.valueOf(1000000))
					.maximunAmount(BigDecimal.valueOf(1000000000))
					.price(BigDecimal.valueOf(1.5))
					.status("0")
					.build();
			
			List.of(rateBootCoin1,rateBootCoin2,rateBootCoin3,rateBootCoin4,rateBootCoin5)
			.forEach(r->rateService.createRateBootcoin(r).subscribe());
		}
	}

}
