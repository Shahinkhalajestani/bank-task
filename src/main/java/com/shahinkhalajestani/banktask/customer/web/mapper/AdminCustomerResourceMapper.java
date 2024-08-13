package com.shahinkhalajestani.banktask.customer.web.mapper;

import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerInquiryDto;
import com.shahinkhalajestani.banktask.customer.service.dto.CustomerSaveDto;
import com.shahinkhalajestani.banktask.customer.web.dto.CustomerInquiryResponseDto;
import com.shahinkhalajestani.banktask.customer.web.dto.CustomerSaveRequestDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResultStatus.class})
public interface AdminCustomerResourceMapper {


	CustomerSaveDto toCustomerSaveDto(CustomerSaveRequestDto customerSaveRequestDto);


	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	CustomerInquiryResponseDto toCustomerInquiryResponseDto(CustomerInquiryDto customerInquiryDto);


}
