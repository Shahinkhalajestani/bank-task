package com.shahinkhalajestani.banktask.customer.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.shahinkhalajestani.banktask.account.model.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "customers", indexes = {
		@Index(name = "customer_id_idx", columnList = "customer_id" , unique = true),
		@Index(name = "phone_number_idx", columnList = "phone_number" , unique = true)
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_id",nullable = false)
	private String customerId;

	@Column(name = "name",nullable = false)
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;

	@CreatedDate
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column(name = "fax_number")
	private String faxNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "customer_type")
	private CustomerType customerType;

	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL})
	@JoinTable(
			name = "customer_accounts",
			joinColumns = @JoinColumn(name = "customer_id"),
			inverseJoinColumns = @JoinColumn(name = "account_id"),
			indexes = {@Index(name = "idx_customer_account_customer_id",columnList = "customer_id"),
					@Index(name = "idx_customer_account_account_id",columnList = "account_id")}
	)
	private Set<Account> accounts = new HashSet<>();


	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	public String fullName(){
		return name + " " + lastName;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) {
			return false;
		}
		Customer customer = (Customer) o;
		return getId() != null && Objects.equals(getId(), customer.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
