package com.shahinkhalajestani.banktask.transaction.exception;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;

public class TransactionOperationFailedException extends BankTaskException {
	public TransactionOperationFailedException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.TRANSACTION_OPERATION_FAILED;
	}
}
