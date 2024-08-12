package com.shahinkhalajestani.banktask.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

	private String message;

	private int code;

	private ResultStatus resultStatus;
}
