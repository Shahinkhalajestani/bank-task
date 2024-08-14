package com.shahinkhalajestani.banktask.customer.service.mapper;

import com.shahinkhalajestani.banktask.customer.service.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;
import com.shahinkhalajestani.banktask.customer.model.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AdminCustomerServiceMapper {

	@Mapping(target = "fullName", expression = "java(customer.fullName())")
	CustomerInquiryDto toCustomerInquiryDto(Customer customer);

	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "customerId", expression = "java(java.util.UUID.randomUUID().toString())")
	Customer toCustomer(CustomerSaveDto customerSaveDto);

}
