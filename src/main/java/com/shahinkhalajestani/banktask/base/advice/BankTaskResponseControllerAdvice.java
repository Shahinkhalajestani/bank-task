package com.shahinkhalajestani.banktask.base.advice;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import lombok.RequiredArgsConstructor;

import org.springframework.core.MethodParameter;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class BankTaskResponseControllerAdvice implements ResponseBodyAdvice<Object> {

	private final Environment environment;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType,
			MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof ResponseModel responseModel && responseModel.getResultStatus().equals(ResultStatus.SUCCESS)){
			responseModel.setMessage(environment.getProperty(ResultStatus.SUCCESS.getDescription()));
		}
		return body;
	}
}
