package com.shahinkhalajestani.banktask.account.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.shahinkhalajestani.banktask.customer.model.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accounts", indexes = {
		@Index(name = "account_id_idx", columnList = "account_id", unique = true)
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_id", nullable = false)
	private String accountId;

	@Column(name = "balance", precision = 10, scale = 2)
	private BigDecimal balance;

	@ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
	private Set<Customer> customers = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private AccountStatus status;
}
