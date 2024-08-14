package com.shahinkhalajestani.banktask.account.dao;

import java.util.Optional;

import javax.swing.text.html.Option;

import com.shahinkhalajestani.banktask.account.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {


	Optional<Account> findByAccountId(String accountId);


}
