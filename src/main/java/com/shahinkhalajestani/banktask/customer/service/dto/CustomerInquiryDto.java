package com.shahinkhalajestani.banktask.customer.service.dto;

import com.shahinkhalajestani.banktask.customer.model.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInquiryDto {

	private String fullName;

	private CustomerType customerType;

	private String faxNumber;

	private String phoneNumber;

	private String customerId;

}
