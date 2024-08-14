package com.shahinkhalajestani.banktask.transaction.exception;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;

public class AccountNotValidForOperationException extends BankTaskException {
	public AccountNotValidForOperationException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.ACCOUNT_STATE_IS_NOT_VALID;
	}
}
