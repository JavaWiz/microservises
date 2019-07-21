package com.javawiz.model;

import java.math.BigDecimal;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.javawiz.service.WebAccountsService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Account DTO - used to interact with the {@link WebAccountsService}.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@JsonRootName("Account")
public class Account {

	private long id;
	private String number;
	private String owner;
	private BigDecimal balance = BigDecimal.ZERO;

	public BigDecimal getBalance() {
		return balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setBalance(BigDecimal value) {
		balance = value;
		balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	@Override
	public String toString() {
		return number + " [" + owner + "]: $" + balance;
	}
}
