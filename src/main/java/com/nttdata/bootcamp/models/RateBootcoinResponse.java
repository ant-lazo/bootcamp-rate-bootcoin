package com.nttdata.bootcamp.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RateBootcoinResponse {
	private String id;
	private String typeTransaction;
	private BigDecimal minimunAmount;
	private BigDecimal maximunAmount;
	private BigDecimal price;
}
