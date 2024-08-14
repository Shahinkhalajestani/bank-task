package com.shahinkhalajestani.banktask.transaction.dao;

import java.util.List;

import com.shahinkhalajestani.banktask.transaction.model.Transaction;
import com.shahinkhalajestani.banktask.transaction.model.TransactionStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TransactionDao extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction>,
		PagingAndSortingRepository<Transaction, Long> {

	List<Transaction> findByStatus(TransactionStatus status);
}
