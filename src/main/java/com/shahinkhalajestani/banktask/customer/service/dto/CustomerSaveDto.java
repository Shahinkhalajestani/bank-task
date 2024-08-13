package com.shahinkhalajestani.banktask.customer.service.dto;

import com.shahinkhalajestani.banktask.customer.model.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveDto {

	private String firstName;

	private String lastName;

	private CustomerType type;

	private String faxNumber;

	private String phoneNumber;

}
