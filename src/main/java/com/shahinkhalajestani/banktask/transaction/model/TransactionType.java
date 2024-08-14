package com.shahinkhalajestani.banktask.transaction.model;

import lombok.Getter;

@Getter
public enum TransactionType {

	DEPOSIT(0),WITHDRAW(1),REFUND(2);

	private final int value;

	TransactionType(int value) {
		this.value = value;
	}

}
