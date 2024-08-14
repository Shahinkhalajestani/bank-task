package com.shahinkhalajestani.banktask.account.exception;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;

public class AccountNotFoundException extends BankTaskException {
	public AccountNotFoundException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.ACCOUNT_NOT_FOUND;
	}
}
