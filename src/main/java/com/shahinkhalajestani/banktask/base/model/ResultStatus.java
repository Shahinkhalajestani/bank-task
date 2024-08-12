package com.shahinkhalajestani.banktask.base.model;

import lombok.Getter;

@Getter
public enum ResultStatus {

	SUCCESS(0, "success"),

	FAILURE(-1, "failure"),

	CUSTOMER_NOT_FOUND(1001, "customer.not.found"),

	DUPLICATE_RECORD_EXCEPTION(1002, "duplicate.record.exception"),;

	private final int code;

	private final String message;

	ResultStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
