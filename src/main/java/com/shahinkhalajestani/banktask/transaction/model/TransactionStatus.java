package com.shahinkhalajestani.banktask.transaction.model;

import lombok.Getter;

@Getter
public enum TransactionStatus {

	IN_PROGRESS(0), SUCCEED(1), FAILED(2);

	private final int value;

	TransactionStatus(int value) {
		this.value = value;
	}

}
