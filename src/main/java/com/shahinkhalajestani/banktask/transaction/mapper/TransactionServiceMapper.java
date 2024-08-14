package com.shahinkhalajestani.banktask.transaction.mapper;

import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionOperationDto;
import com.shahinkhalajestani.banktask.transaction.service.dto.TransactionResultDto;
import com.shahinkhalajestani.banktask.transaction.model.Transaction;
import com.shahinkhalajestani.banktask.transaction.model.TransactionStatus;
import com.shahinkhalajestani.banktask.transaction.model.TransactionType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",imports = { TransactionStatus.class, TransactionType.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionServiceMapper {

	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "transactionId", expression = "java(java.util.UUID.randomUUID().toString())")
	@Mapping(target = "fromAccountId" , source = "fromAccount")
	@Mapping(target = "toAccountId" , source = "toAccount")
	Transaction toTransaction(TransactionOperationDto transactionOperationDto);

	@Mapping(target = "completionDate", source = "endDate")
	@Mapping(target = "fromAccount", source = "fromAccountId")
	@Mapping(target = "toAccount", source = "toAccountId")
	TransactionResultDto toTransactionResultDto(Transaction transaction);

	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "status", expression = "java(TransactionStatus.IN_PROGRESS)")
	@Mapping(target = "type", expression = "java(TransactionType.REFUND)")
	@Mapping(target = "startDate", expression = "java(java.time.LocalDateTime.now())")
	@Mapping(target = "fromAccountId", source = "fromAccountId")
	@Mapping(target = "toAccountId", source = "fromAccountId")
	Transaction toRefundTransaction(Transaction transaction);


	default Page<TransactionResultDto> toTransactionResultDtoPage(Page<Transaction> transactions){
		return transactions.map(this::toTransactionResultDto);
	}

}
