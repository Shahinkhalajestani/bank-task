package com.shahinkhalajestani.banktask.transaction.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.shahinkhalajestani.banktask.transaction.dto.TransactionInquiryDto;
import com.shahinkhalajestani.banktask.transaction.model.Transaction;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;

import org.springframework.data.jpa.domain.Specification;

public class TransactionSpecification {

	public static Specification<Transaction> getTransactionsByRequest(TransactionInquiryDto request) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(request.getTransactionId())) {
				predicates.add(criteriaBuilder.equal(root.get("transactionId"), request.getTransactionId()));
			}

			if (Objects.nonNull(request.getFromDate())) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("start_date"), request.getFromDate()));
			}

			if (request.getToDate() != null) {
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("end_date"), request.getToDate()));
			}

			if (request.getAmount() != null) {
				predicates.add(criteriaBuilder.equal(root.get("amount"), request.getAmount()));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
