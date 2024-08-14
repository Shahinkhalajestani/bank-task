package com.shahinkhalajestani.banktask.transaction.model;

import lombok.Getter;

@Getter
public enum TransactionType {

	PAYMENT(0),REFUND(1);

	private final int value;

	TransactionType(int value) {
		this.value = value;
	}

}
