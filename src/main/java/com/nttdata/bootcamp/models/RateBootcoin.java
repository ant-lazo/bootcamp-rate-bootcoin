package com.nttdata.bootcamp.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ratesbootcoins")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RateBootcoin {
	@Id
	private String id;
	private String description;
	private String typeTransaction;
	private BigDecimal minimunAmount;
	private BigDecimal maximunAmount;
	private BigDecimal price;
	private String status;// 0=> inactivo || 1=> activo
	
	public boolean isActive() {
		return this.status.equals("1");
	}
}
