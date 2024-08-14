package com.shahinkhalajestani.banktask.transaction.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.shahinkhalajestani.banktask.transaction.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TransactionDao extends JpaRepository<Transaction, Long> {

	List<Transaction> findByFromAccountId(String fromAccountId);

	List<Transaction> findByToAccountId(String toAccountId);

	List<Transaction> findByFromAccountIdAndToAccountId(String fromAccountId, String toAccountId);

	@Query("SELECT t FROM Transaction AS t WHERE t.startDate >= :fromDate AND t.endDate <= :toDate")
	List<Transaction> findByDateBetween(@Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);
}
