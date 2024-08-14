package com.shahinkhalajestani.banktask.base.model;

import lombok.Getter;

@Getter
public enum ResultStatus {

	SUCCESS(0, "success"),

	FAILURE(-1, "failure"),

	CUSTOMER_NOT_FOUND(1001, "customer.not.found"),

	DUPLICATE_RECORD(1002, "duplicate.record.exception"),

	RECORD_NOT_FOUND(1003, "record.not.found"),
	INVALID_PARAMETER(1004, "invalid.parameter"),
	ACCOUNT_NOT_FOUND(1005,"account.not.found"),
	TRANSACTION_OPERATION_FAILED(1006, "transaction.operation.failed"),
	ACCOUNT_STATE_IS_NOT_VALID(1007, "account.state.not_valid"),;

	private final int code;

	private final String description;

	ResultStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
}
