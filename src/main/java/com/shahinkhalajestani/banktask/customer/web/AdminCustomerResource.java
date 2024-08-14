package com.shahinkhalajestani.banktask.customer.web;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import com.shahinkhalajestani.banktask.customer.service.AdminCustomerService;
import com.shahinkhalajestani.banktask.customer.web.dto.CustomerInquiryResponseDto;
import com.shahinkhalajestani.banktask.customer.web.dto.CustomerSaveRequestDto;
import com.shahinkhalajestani.banktask.customer.web.mapper.AdminCustomerResourceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/customer")
public class AdminCustomerResource {


	private final AdminCustomerResourceMapper mapper;

	private final AdminCustomerService adminCustomerService;

	@PostMapping
	public ResponseEntity<ResponseModel> saveCustomer(@RequestBody @Valid CustomerSaveRequestDto customerSaveRequestDto) {
		log.info("saving customer with phone number : {}", customerSaveRequestDto.getPhoneNumber());
		adminCustomerService.saveCustomer(mapper.toCustomerSaveDto(customerSaveRequestDto));
		return ResponseEntity.ok(ResponseModel.success());
	}

	@GetMapping
	public ResponseEntity<CustomerInquiryResponseDto> getCustomer(@RequestParam(name = "phoneNumber", required = false) String phoneNumber,
			@RequestParam(name = "customerId", required = false) String customerId) {
		log.info("going to fetch customer with either customer Id or phoneNumber, {},{}"
				, StringUtils.isNotBlank(customerId) ? customerId : "", StringUtils.isNotBlank(phoneNumber) ? phoneNumber : "");
		var customerInquiryDto = adminCustomerService.getCustomerWithIdOrPhoneNumber(customerId,phoneNumber);
		return ResponseEntity.ok(mapper.toCustomerInquiryResponseDto(customerInquiryDto));
	}

}
