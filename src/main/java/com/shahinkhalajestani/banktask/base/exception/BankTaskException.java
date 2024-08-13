package com.shahinkhalajestani.banktask.base.exception;

import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import lombok.Getter;

@Getter
public class BankTaskException extends RuntimeException {

	private final ResultStatus status;

	public BankTaskException(String message) {
		super(message);
		this.status = ResultStatus.FAILURE;
	}
}
