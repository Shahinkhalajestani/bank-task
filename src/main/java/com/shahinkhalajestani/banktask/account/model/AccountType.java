package com.shahinkhalajestani.banktask.account.model;

import lombok.Getter;

@Getter
public enum AccountType {

	LONG_TERM_DEPOSIT(0),SHORT_TERM_DEPOSIT(1);

	private final int value;


	AccountType(int value) {
		this.value = value;
	}

}
