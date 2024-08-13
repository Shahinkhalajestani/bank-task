package com.shahinkhalajestani.banktask.customer.exception;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;

public class CustomerNotFoundException extends BankTaskException {

	public CustomerNotFoundException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.CUSTOMER_NOT_FOUND;
	}


}
