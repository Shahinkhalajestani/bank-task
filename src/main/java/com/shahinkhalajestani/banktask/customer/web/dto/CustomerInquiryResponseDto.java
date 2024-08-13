package com.shahinkhalajestani.banktask.customer.web.dto;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import com.shahinkhalajestani.banktask.customer.model.CustomerType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerInquiryResponseDto extends ResponseModel {

	private String fullName;

	private CustomerType customerType;

	private String faxNumber;

	private String phoneNumber;

	private String customerId;
}
