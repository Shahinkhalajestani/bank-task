package com.shahinkhalajestani.banktask.customer.web.dto;

import com.shahinkhalajestani.banktask.customer.model.CustomerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequestDto {

	@NotBlank
	private String name;

	@NotBlank
	private String lastName;

	@NotNull
	private CustomerType customerType;


	private String faxNumber;


	@Pattern(regexp = "^09\\d{9}$", message = "Phone number must start with 09 and be followed by 9 digits")
	private String phoneNumber;

}

