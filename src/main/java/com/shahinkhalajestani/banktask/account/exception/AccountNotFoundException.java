package com.shahinkhalajestani.banktask.account.exception;

import com.shahinkhalajestani.banktask.base.exception.BankTaskException;

public class AccountNotFoundException extends BankTaskException {
	public AccountNotFoundException(String message) {
		super(message);
	}
}
