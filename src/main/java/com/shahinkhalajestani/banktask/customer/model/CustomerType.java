package com.shahinkhalajestani.banktask.customer.model;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum CustomerType {

	REAL(0),LEGAL(1);

	private final int value;

	CustomerType(int value) {
		this.value = value;
	}

	public CustomerType fromValue(int value) {
		return Arrays.stream(CustomerType.values()).filter(customerType -> customerType.value == value)
				.findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid value for customer type"
						+ value));
	}

}
