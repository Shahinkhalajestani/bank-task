package com.shahinkhalajestani.banktask.account.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
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
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "accounts", indexes = {
		@Index(name = "account_id_idx", columnList = "account_id", unique = true)
})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_id", nullable = false)
	private String accountId;

	@Column(name = "balance", precision = 10, scale = 2)
	private BigDecimal balance;

	@ManyToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
	@Exclude
	private Set<Customer> customers = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private AccountStatus status;

	@CreatedDate
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Override
	public final boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Account account)) {
			return false;
		}

		return Objects.equals(getId(), account.getId()) && Objects.equals(getAccountId(), account.getAccountId()) && Objects.equals(getBalance(), account.getBalance()) && Objects.equals(getCustomers(), account.getCustomers()) && getStatus() == account.getStatus();
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(getId());
		result = 31 * result + Objects.hashCode(getAccountId());
		result = 31 * result + Objects.hashCode(getBalance());
		result = 31 * result + Objects.hashCode(getCustomers());
		result = 31 * result + Objects.hashCode(getStatus());
		return result;
	}
}
