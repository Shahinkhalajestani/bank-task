package com.shahinkhalajestani.banktask.transaction.web.dto;

import java.util.List;

import com.shahinkhalajestani.banktask.base.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TransactionInquiryResponse extends ResponseModel {

	private Page<TransactionInquiryResult> transactions;

}
