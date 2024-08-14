package com.shahinkhalajestani.banktask.transaction.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction",
		indexes = { @Index(name = "trx_start_end_date_idx", columnList = "start_date, end_date"),
				@Index(name = "transaction_id", unique = true, columnList = "transaction_id"),
				@Index(name = "trx_from_account_id_idx", columnList = "from_account_id"),
				@Index(name = "trx_to_account_id_idx", columnList = "to_account_id"),
				@Index(name = "trx_state_idx", columnList = "status")})
@Setter
@Getter
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "transaction_id", nullable = false)
	private String transactionId;

	@Column(name = "start_date", nullable = false)
	private LocalDateTime startDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	@Column(name = "from_account_id", nullable = false)
	private String fromAccountId;

	@Column(name = "to_account_id", nullable = false)
	private String toAccountId;

	@Column(name = "amount", nullable = false)
	private Long amount;

	@Enumerated(value = EnumType.STRING)
	private TransactionStatus status;

	@Enumerated(value = EnumType.STRING)
	private TransactionType type;

	public Transaction() {
		this.startDate = LocalDateTime.now();
		this.status = TransactionStatus.IN_PROGRESS;
		this.type = TransactionType.PAYMENT;
	}
}
