package com.shahinkhalajestani.banktask.base.exception;

import com.shahinkhalajestani.banktask.base.model.ResultStatus;

public class DuplicateRecordException extends BankTaskException{
	public DuplicateRecordException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.DUPLICATE_RECORD_EXCEPTION;
	}
}
