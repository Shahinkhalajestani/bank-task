package com.shahinkhalajestani.banktask.account.model;

import lombok.Getter;

@Getter
public enum AccountStatus {

	AVAILABLE(0),BLOCKED(1);


	private final int value;

	AccountStatus(int value) {
		this.value = value;
	}
}
