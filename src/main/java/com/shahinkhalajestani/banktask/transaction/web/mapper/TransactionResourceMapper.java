package com.shahinkhalajestani.banktask.transaction.web.mapper;

import com.shahinkhalajestani.banktask.base.model.ResultStatus;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionInquiryDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionResultDto;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionInquiryRequest;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionInquiryResponse;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionInquiryResult;
import com.shahinkhalajestani.banktask.transaction.web.dto.TransactionOperationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TransactionResourceMapper {

	TransactionInquiryResult toTransactionInquiryResult(TransactionResultDto transactionResultDto);

	TransactionInquiryDto toTransactionInquiryDto(TransactionInquiryRequest transactionInquiryRequest);

	default TransactionInquiryResponse toTransactionInquiryResponse(Page<TransactionResultDto> transactions) {
		var transactionInquiryResponse = new TransactionInquiryResponse();
		transactionInquiryResponse.setTransactions(transactions.map(this::toTransactionInquiryResult));
		transactionInquiryResponse.setResultStatus(ResultStatus.SUCCESS);
		return transactionInquiryResponse;
	}

	TransactionOperationDto toTransactionOperationDto(TransactionOperationRequest transactionOperationRequest);

}
