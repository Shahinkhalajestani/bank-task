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

	public ResponseModel(ResultStatus resultStatus) {
		this.code = resultStatus.getCode();
		this.resultStatus = resultStatus;
	}

	public static ResponseModel success() {
		var result = new ResponseModel();
		result.setResultStatus(ResultStatus.SUCCESS);
		result.setCode(ResultStatus.SUCCESS.getCode());
		return result;
	}
}
